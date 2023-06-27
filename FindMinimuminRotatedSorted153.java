//Given the sorted rotated array nums of unique elements,
// return the minimum element of this array.
//
//You must write an algorithm that runs in O(log n) time.
package leetcode;

public class FindMinimuminRotatedSorted153
{
	public int findMin(int[] nums)
	{
		int end = nums.length - 1;
		int start = 0;
		while (end > start)
		{
			int middle = (end + start) / 2;
			
			if (nums[middle] < nums[end])
			{
				end = middle;
			}
			else
			{
				start = middle + 1;
			}
		}
		return nums[start];
	}
}