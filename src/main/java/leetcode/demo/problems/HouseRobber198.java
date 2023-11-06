package leetcode.demo.problems;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] da = new int[n];
        da[0] = nums[0];
        da[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            da[i] = Math.max(nums[i] + da[i - 2], da[i - 1]);
        }
        return Math.max(da[n - 1], da[n - 2]);
    }
}