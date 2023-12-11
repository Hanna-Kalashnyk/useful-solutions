package leetcode.demo.problems;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 */
public class JumpGame55 {
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        return topDown(0, nums, memo);
    }

    public boolean topDown(int start, int[] nums, int[] memo) {
        if (start == nums.length - 1) {
            memo[start] = 1;
            return true;
        }
        if (start < nums.length && nums[start] != 0) {
            for (int i = 1; i <= nums[start]; i++) {
                if (start + i < nums.length) {
                    if (memo[start + i] == 1) {
                        return true;
                    } else {
                        if (topDown(start + i, nums, memo)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean jump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = n; i > 0; n --) {
            for (int num : nums) {
                for (int j = 1; j <= num; i++){
                    dp[i] = dp[i] || dp[i - j];

                }
            }
        }
        return dp[n];
    }

    public boolean canJump3(int[] nums) {
        int reach = 0;

        for (int idx = 0; idx < nums.length; idx++) {
            //at every index I'll check if my reach was atleast able to
            //reach that particular index.

            //reach >= idx -> great, carry on. Otherwise,
            if(reach < idx) return false;

            //now as you can reach this index, it's time to update your reach
            //as at every index, you're getting a new jump length.
            reach = Math.max(reach, idx + nums[idx]);
        }

        //this means that you reached till the end of the array, wohooo!!
        return true;

    }
    public boolean canJump4(int[] nums) {
        if (nums.length == 0)
            throw new IllegalArgumentException("nums can't be empty");
        int farthest = 0;
        for (int i = 0; i <= farthest && i < nums.length; ++i) {
            farthest = Math.max(farthest, i + nums[i]);
        }
        return farthest >= nums.length - 1;
    }
}

