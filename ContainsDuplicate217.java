//Given an integer array nums, return true if any value appears at least twice in the array,
// and return false if every element is distinct.
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate217
{
	public boolean containsDuplicate(int[] nums)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			if (map.containsKey(nums[i]))
				return true;
			map.put(nums[i], 1);
		}
		return false;
	}
}