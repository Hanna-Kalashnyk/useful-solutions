//Given an integer array nums, return the length of
// the longest strictly increasing subsequence
package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence300 {
    public int lengthOfIncreasingList(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                getFoundAndReplace(list, nums[i]);
            }
        }
        int size = list.size();
        return size;
    }

    private ArrayList<Integer> getFoundAndReplace(ArrayList<Integer> list, int target) {
        int m = 0;
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {

            m = (start + end) / 2;
            if (list.get(m) <= target) {
                start = m + 1;
            } else {
                end = m - 1;
            }
        }
        if (list.get(Math.max(end, 0)) == target) list.set(end, target);
        else {
            list.set(start, target);
        }

        return list;
    }

    //time complexity n*log(n)
    public int lIS(int[] nums) {

                int n = nums.length;
                if (n == 0) return 0;

                int[] dp = new int[n];
                int len = 1;
                dp[0] = nums[0];

                for (int i = 1; i < n; i++) {
                    if (nums[i] > dp[len - 1]) {
                        dp[len] = nums[i];
                        len++;
                    } else {
                        int idx = Arrays.binarySearch(dp, 0, len, nums[i]);
                        if (idx < 0) {
                            idx = -idx - 1;
                        }
                        dp[idx] = nums[i];
                    }
                }

                return len;
            }
        }

//	public int lengthOfLIS(int[] nums) {
//		int[] tails = new int[nums.length];
//		int size = 0;
//		for (int x : nums) {
//			int i = 0, j = size;
//			while (i != j) {
//				int m = (i + j) / 2;
//				if (tails[m] < x)
//					i = m + 1;
//				else
//					j = m;
//			}
//			tails[i] = x;
//			if (i == size) ++size;
//		}
//		return size;
//	}}


