package leetcode.demo.problems;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 */
public class JumingGame45 {
    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int far = 0;
        int n = nums.length;
        int count = 0;
        while (right < n - 1) {
            for (int i = left; i <= right; i++) {
                far = Math.max(far, i + nums[i]);
            }
            left = right + 1;
            right = far;
            count++;
        }
        return count;
    }
}
