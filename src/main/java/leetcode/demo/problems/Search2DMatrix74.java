package leetcode.demo.problems;

import java.util.Arrays;

/**
 * You are given an m x n integer  matrix with the following two properties:
 * <p>
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * <p>
 * You must write a solution in O(log(m * n)) time complexity.
 */
public class Search2DMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int w = matrix[0].length;
        int n = matrix.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (matrix[m][w - 1] >= target && matrix[m][0] <= target) {
                return lookupInRow(matrix[m], target);
            } else if (matrix[m][w - 1] < target) {
                i = m + 1;
            } else if (matrix[m][0] > target) {
                j = m - 1;
            }
        }
        return lookupInRow(matrix[i], target);
    }

    private static boolean lookupInRow(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target;
        return Arrays.binarySearch(nums, target) >= 0;
    }
}
