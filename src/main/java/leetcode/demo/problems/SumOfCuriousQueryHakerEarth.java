package leetcode.demo.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * return the sum of elements of Array, which are at condition of Query: {L, R}, where:
 * i <= L && A[i] > R.
 */

public class SumOfCuriousQueryHakerEarth {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine().strip();
        int tests = Integer.parseInt(name);
        for (int i = 0; i < tests; i++) {
            String[] arrayQueryLengths = br.readLine().strip().split(" ");
            int arrayLength = Integer.parseInt(arrayQueryLengths[0]);
            int[] arr = new int[arrayLength];
            int queryNumbers = Integer.parseInt(arrayQueryLengths[1]);

            String[] array = br.readLine().strip().split(" ");
            for (int k = 0; k < arrayLength; k++) {
                arr[k] = Integer.parseInt(array[k]);
            }

            for (int q = 0; q < queryNumbers; q++) {
                int[] query = new int[2];
                String[] quer = br.readLine().strip().split(" ");
                query[0] = Integer.parseInt(quer[0]);
                query[1] = Integer.parseInt(quer[1]);
                System.out.print(count(arr, query) + " ");
            }
            System.out.println("");
        }
    }

    public static int count(int[] arr, int[] query) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i <= query[0] && arr[i] > arr[query[1]]) sum += arr[i];
        }
        return sum;
    }
}