//Given an integer array nums, return true if you can partition the array into
// two subsets such that the sum of the elements in both subsets is equal or false otherwise.
package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class PartitionEqualSubsetSum416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for(int i : nums) sum+=i;

        if(sum%2!=0) return false;

        sum /= 2;

        boolean[] dp = new boolean[sum+1];

        dp[0] = true;

        for (int j : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= j) {
                    dp[i] = dp[i] || dp[i-j];
                }
            }
        }
        return dp[sum];
    }
}




//        int halfSum = Arrays.stream(nums).sum();
//        if (halfSum % 2 == 1) return false;
//        else return compileSum(0, nums, new ArrayList<Integer>(), halfSum, 0, false);
//    }
//
//    boolean compileSum(int number, int[] nums, ArrayList<Integer> list, int sum, int tempSum, boolean rez) {
//        if (tempSum == sum) rez = true;
//        for (int i = number; i < nums.length; i++) {
//            list.add(nums[i]);
//            tempSum += nums[i];
//            compileSum(i+1, nums, list, sum, tempSum, rez);
//            list.remove(list.size() - 1);
//            tempSum -= nums[i];
//        }
//        return rez;
//    }
//}