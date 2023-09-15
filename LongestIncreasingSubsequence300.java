//Given an integer array nums, return the length of
// the longest strictly increasing subsequence
package leetcode;

import java.util.ArrayList;

public class 	LongestIncreasingSubsequence300
{
//	public int lengthOfListContiniousWithoutSkips(int[] nums)
//	{
//		int max = 0;
//		int start = 0;
//		for (int i = 1; i < nums.length; i++)
//		{
//			if (nums[i] <= nums[i - 1])
//			{
//				max = Math.max(max, i - start);
//				start = i;
//			}
//			if (i == nums.length && nums[i] > nums[i - 1])
//			{
//				max = Math.max(max, i - start + 1);
//			}
//		}
//		return max;
//	}
	
	public int lengthOfIncreasingList(int[] nums)
	{
		int n = nums.length;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(nums[0]);
		for (int i = 1; i < n; i++)
		{
				if (nums[i] > list.get(list.size()-1))
				{
					list.add(nums[i]);
				}
				else
				{
					getFoundAndReplace(list, nums[i]);
				}
		}
		int size = list.size();
		return size;
	}
	
	private ArrayList<Integer> getFoundAndReplace(ArrayList<Integer> list, int target)
	{
		int m = 0;
		int start = 0;
		int end = list.size() - 1;
		while (start <= end)
		{
			
			m = (start + end) / 2;
			if (list.get(m) <= target)
			{
				start = m + 1 ;
			}
			else
			{
				end = m - 1;
			}
		}
		if (list.get(Math.max(end,0)) == target)list.set(end, target);
		else {list.set(start, target);}
		
		return list;
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