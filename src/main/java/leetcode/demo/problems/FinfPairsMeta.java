package leetcode.demo.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Find the number of directed pairs among the int array, which satisfied the condition:
 * Arr[i] - Arr[j] = i - j; i != j;
 * Examples:
 * 3
 * 1 2 3
 * Ans -> 6
 *
 * 4
 * 1 2 3 4
 * ans -> 12
 */
public class FinfPairsMeta {

    public static void main(String args[]) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();   // Reading input from STDIN
        int N = Integer.parseInt(line1);
        String line2 = br.readLine();
        String[] lines = line2.split(" ");
        //int N = Integer.parseInt(lines[0]);

        //assert line.length == N;  // or some other equivalent check
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(lines[i]);
        }

        int res = findPairs(arr);
        System.out.println(res);    // Writing output to STDOUT
    }

    public static int findPairs(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i + 1) list.add(arr[i]);
        }
        int n = list.size();

        return n % 2 == 0 ? n * n - n : 2 * n * (n / 2);
    }
    public static int findPairsSimple(int[] arr) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j && arr[i] - arr[j] == i - j) {
                    count++;
                }
            }
        }

        return 2 * count;
    }

    public static int findPairMap(int[] nums){
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i] - i, map.getOrDefault(nums[i] - i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                int n = entry.getValue();
                count += n % 2 == 0 ? n * n - n : 2 * n * (n / 2);
            }
        }
        return count;
    }
}
