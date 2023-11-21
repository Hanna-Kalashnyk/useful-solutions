//Given an integer array nums, find the
//subarray
// with the largest sum, and return its sum.
package leetcode.demo.problems;

public class MaximumSubarray53
{
		public int maxSubArray(int[] nums)
	{
		int max = 0;
		int curr = 0;
		for (int i = 0; i < nums.length; i++)
		{
			curr += nums[i];
			if (max < curr)
			{
				max = curr;
			}
		}
		for (int i = 0; i < nums.length; i++)
		{
			curr -= nums[i];
			if (max < curr)
			{
				max = curr;
			}
		}
		return max;
	}
	
	public int maxSubArray2(int[] nums)
	{
		int answer = Integer.MIN_VALUE;
		int max = 0;
		for (int num : nums)
		{
			max += num;
			answer = Math.max(answer, max);
			max = Math.max(max, 0);
		}
		return answer;
	}
}
