package leetcode.demo.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums, return the number of longest increasing subsequences.
 * <p>
 * Notice that the sequence has to be strictly increasing.
 */
public class NumberofLongestIncreasingSubsequenc673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] ba = new int[n];
        ba[0] = nums[0];
        int len = 1;
        PriorityQueue<Integer> temp = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i] > ba[len - 1]) {
                ba[len] = nums[i];
                len++;
                if (!temp.isEmpty()) {
                    int prev = 0;
                    while (!temp.isEmpty() && temp.poll() < nums[i]) {
                        temp.poll();
                        prev++;
                    }
                    map.put(len, prev);
                    temp.clear();
                } else {
                    map.put(len, map.getOrDefault(len - 1, 1));
                }
            } else {
                int place = Arrays.binarySearch(ba, 0, len, nums[i]);
                //    if (place == len - 1 || place < 0 && -place - 1 == len - 1)map.put(len, map.get(len) + 1);
                if (place < 0) {
                    ba[-place - 1] = nums[i];
                    if (-place - 1 == len - 1) {
                        map.put(len, map.get(len) + 1);
                    }
                } else {
                    if (place == len - 1) {
                        map.put(len, map.getOrDefault(len, 0) + 1);

                    }
                }
            } temp.add(nums[i]);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        queue.addAll(map.entrySet());
        if (queue.isEmpty()) return 0;
        return queue.peek().getValue();
    }
}

