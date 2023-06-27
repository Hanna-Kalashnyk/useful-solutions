package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class ShuffledString{
	public String restoreString(String s, int[] indices) {
		
		StringBuilder sb = new StringBuilder();
		Map<Integer, Character> map = new HashMap<>();
		for (int i = 0; i < indices.length; i++)
		{
			map.put(indices[i], s.charAt(i));
		}
		PriorityQueue<Map.Entry<Integer, Character>> priorityQueue = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
		
		for (Map.Entry<Integer, Character> entry : map.entrySet()) {
			priorityQueue.offer(entry);
		}
		
		while (!priorityQueue.isEmpty()) {
			sb.append(priorityQueue.poll().getValue());
		}
		
		return sb.toString();
	}
}