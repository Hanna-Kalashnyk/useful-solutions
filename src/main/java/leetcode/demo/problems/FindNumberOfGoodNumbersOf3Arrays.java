package leetcode.demo.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * find the number of elements from int A[], where A[i] = B[C[j]]; 0 <= i < j < length;
 */
public class FindNumberOfGoodNumbersOf3Arrays {
    public static void main(String args[]) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine().strip();              // Reading input from STDIN
        int numberOfTests = Integer.parseInt(name);
        List res = new ArrayList<Integer>();
        int length;
        int[] arrA;
        int[] arrB;
        int[] arrC;
        for (int k = 0; k < numberOfTests; k++) {
            String n = br.readLine().strip();                // Reading input from STDIN
            length = Integer.parseInt(n);
            String arrayA = br.readLine().strip();               // Reading input from STDIN
            String[] A = arrayA.split(" ");
            String arrayB = br.readLine().strip();               // Reading input from STDIN
            String[] B = arrayB.split(" ");
            String arrayC = br.readLine().strip();               // Reading input from STDIN
            String[] C = arrayC.split(" ");

            arrA = new int[length];
            arrB = new int[length];
            arrC = new int[length];
            for (int i = 0; i < length; i++) {
                arrA[i] = Integer.parseInt(A[i]);
                arrB[i] = Integer.parseInt(B[i]);
                arrC[i] = Integer.parseInt(C[i]);
            }
            res.add(findGoodInd(arrA, arrB, arrC, length));
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static int findGoodInd(int[] arr, int[] brr, int[] crr, int length) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (crr[i] >= 0 && crr[i] < length)
                map.put(brr[crr[i]], map.getOrDefault(brr[crr[i]], 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(arr[i])) count += map.get(arr[i]);
        }
        return count;
    }
}
