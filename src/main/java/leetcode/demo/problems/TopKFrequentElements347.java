//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
package leetcode.demo.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements347
{
	public int[] topKFrequent(int[] nums, int k)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			queue.add(entry);
		}
		
		int[] res = new int[k];
		for (int i = 0; i < k; i++)
		{
			res[i] = queue.poll().getKey();
		}
		return res;
	}
}
