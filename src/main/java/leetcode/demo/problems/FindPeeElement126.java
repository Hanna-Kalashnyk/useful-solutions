package leetcode.demo.problems;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 * <p>
 * Given a 0-indexed integer array nums, find a peak element, and return its index.
 * If the array contains multiple peaks, return the index to any of the peaks.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered
 * to be strictly greater than a neighbor that is outside the array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 */
public class FindPeeElement126 {
    public int findPeekElement(int[] nums) {
        int n = nums.length;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 2] < nums[n - 1]) return n - 1;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int m = (j - i) / 2;
            if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) {
                return m;
            } else if (nums[m - 1] > nums[m]) {
                j = m;
            } else if (nums[m + 1] > nums[m]) i = m;
        }
        return i;
    }
}
