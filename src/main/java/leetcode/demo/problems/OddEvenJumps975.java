package leetcode.demo.problems;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * You are given an integer array arr. From some starting index, you can make a series of jumps.
 * The (1st, 3rd, 5th, ...) jumps in the series are called odd-numbered jumps, and the (2nd, 4th, 6th, ...)
 * jumps in the series are called even-numbered jumps. Note that the jumps are numbered, not the indices.
 *
 * You may jump forward from index i to index j (with i < j) in the following way:
 *
 * During odd-numbered jumps (i.e., jumps 1, 3, 5, ...), you jump to the index j such that arr[i] <= arr[j]
 * and arr[j] is the smallest possible value. If there are multiple such indices j, you can only jump to the smallest such index j.
 * During even-numbered jumps (i.e., jumps 2, 4, 6, ...), you jump to the index j such that arr[i] >= arr[j]
 * and arr[j] is the largest possible value. If there are multiple such indices j, you can only jump to the smallest such index j.
 * It may be the case that for some index i, there are no legal jumps.
 * A starting index is good if, starting from that index, you can reach the end of the array (index arr.length - 1)
 * by jumping some number of times (possibly 0 or more than once).
 *
 * Return the number of good starting indices.
 */
public class OddEvenJumps975 {
    public int oddEvenJumps(int[] arr) {

        TreeMap<Integer,Integer> tm = new TreeMap<>();
        int ind = 0;


        int[] oddArr = new int[arr.length];
        int[] evenArr = new int[arr.length];

        int n = arr.length;
        tm.put(arr[n-1], n - 1);
        Arrays.fill(oddArr, -1);
        Arrays.fill(evenArr, -1);

        for(int i = n- 2; i>=0; i--) {
            Map.Entry<Integer,Integer> hEntry = tm.ceilingEntry(arr[i]);
            if(hEntry != null) {
                oddArr[i] = hEntry.getValue();
            }

            Map.Entry<Integer,Integer> lEntry = tm.floorEntry(arr[i]);
            if(lEntry != null) {
                evenArr[i] = lEntry.getValue();
            }
            tm.put(arr[i], i);
        }

        boolean dp[][] = new boolean[n][2];
        for(boolean i[] : dp) {
            Arrays.fill(i, false);
        }
        dp[n-1][0] = true;
        dp[n-1][1] = true;
        int ans = 1;

        for(int i = n-2; i>=0; i--) {
            if(oddArr[i] != -1)
                dp[i][0] = dp[oddArr[i]][1];
            if(evenArr[i] != -1)
                dp[i][1] = dp[evenArr[i]][0];
            if(dp[i][0]) ans++;
        }

        return ans;
    }
    public int oddEvenJumps2(int[] arr) {

        TreeMap<Integer,Integer> tm = new TreeMap<>();
        int ind = 0;


        int oddArr[] = new int[arr.length];
        int evenArr[] = new int[arr.length];

        int n = arr.length;
        tm.put(arr[n-1], n - 1);
        Arrays.fill(oddArr, -1);
        Arrays.fill(evenArr, -1);

        for(int i = n- 2; i>=0; i--) {
            Map.Entry<Integer,Integer> hEntry = tm.ceilingEntry(arr[i]);
            if(hEntry != null) {
                oddArr[i] = hEntry.getValue();
            }

            Map.Entry<Integer,Integer> lEntry = tm.floorEntry(arr[i]);
            if(lEntry != null) {
                evenArr[i] = lEntry.getValue();
            }
            tm.put(arr[i], i);
        }

        boolean dp[][] = new boolean[n][2];
        for(boolean i[] : dp) {
            Arrays.fill(i, false);
        }
        dp[n-1][0] = true;
        dp[n-1][1] = true;
        int ans = 1;

        for(int i = n-2; i>=0; i--) {
            if(oddArr[i] != -1)
                dp[i][0] = dp[oddArr[i]][1];
            if(evenArr[i] != -1)
                dp[i][1] = dp[evenArr[i]][0];
            if(dp[i][0]) ans++;
        }

        return ans;
    }
}
