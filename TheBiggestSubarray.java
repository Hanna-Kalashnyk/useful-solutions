//Find the maximum subarray
// - Write a function that takes an array of integers
// as input and returns the contiguous subarray with the largest sum.
//
// For example, if the input array is [-2, 1, -3, 4, -1, 2, 1, -5, 4],
// the function should return [4, -1, 2, 1].

package leetcode;

import java.util.Arrays;

public class TheBiggestSubarray
{
    public static int[] maxSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
    return null;
}
    int maxSum = nums[0];
    int currSum = nums[0];
    int maxStart = 0;
    int maxEnd = 0;
    int currStart = 0;
    for (int i = 1; i < nums.length; i++) {
    if (currSum < 0) {
        currSum = nums[i];
        currStart = i;
    } else {
        currSum += nums[i];
    }
    if (currSum > maxSum) {
        maxSum = currSum;
        maxStart = currStart;
        maxEnd = i;
    }
}
    return Arrays.copyOfRange(nums, maxStart, maxEnd + 1);
}
}
