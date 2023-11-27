package leetcode.demo.problems;

import java.util.Arrays;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 * <p>
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * <p>
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
 * or -1 if it is not in nums.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInRotatedArray33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int ind = 0;
        if (nums[0] > nums[n - 1]) {
            int min = find0Index(nums);
            if (target <= nums[nums.length - 1]) {
                ind = Arrays.binarySearch(nums, min, nums.length, target);
            } else {
                ind = Arrays.binarySearch(nums, 0, min, target);
            }
        } else {
            ind = Arrays.binarySearch(nums, target);
        }
        return ind < 0 ? -1 : ind;
    }

    private int find0Index(int[] nums) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] < nums[i]) {
                j = m;
            } else if (nums[m] > nums[nums.length - 1]) {
                if (nums[m + 1] < nums[m]) return m + 1;
                i = m;

            }
        }
        return i + 1;
    }
}
