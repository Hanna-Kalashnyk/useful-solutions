package leetcode.demo.problems;

import java.util.Arrays;

/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 */
public class FirstMissingPositive41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == 1 ? 2 : 1;
        }
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) flag = true;
            if (nums[i] < 0 || nums[i] > n) nums[i] = 1;
        }
        if (flag == false) return 1;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) return nums[i] + 1;
        }
        return nums[n - 1] + 1;
    }
}
