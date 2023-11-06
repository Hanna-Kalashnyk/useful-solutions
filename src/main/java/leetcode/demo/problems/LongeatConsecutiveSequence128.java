package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 */
public class LongeatConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int num : nums) {
            pq.offer(num);
        }
        if (pq.isEmpty()) return 0;
        int curmax = 1;
        int max = 1;
        int previous = pq.poll();
        while (!pq.isEmpty()) {
            int curElement = pq.poll();
            if (previous - curElement > 1) {
                max = Math.max(max, curmax);
                curmax = 1;
            } else if (previous - curElement == 1) {
                curmax++;
            }
            previous = curElement;
        }
        max = Math.max(max, curmax);
        return max;
    }
}