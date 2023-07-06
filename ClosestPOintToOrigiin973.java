//Given an array of points where points[i] = [xi, yi]
// represents a point on the X-Y plane and an integer k,
// return the k closest points to the origin (0, 0).
//
//The distance between two points on the X-Y plane is
// the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
//
//You may return the answer in any order.
// The answer is guaranteed to be unique (except for the order that it is in).
package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ClosestPOintToOrigiin973
{
	public int[][] kClosest(int[][] points, int k)
	{
		HashMap<Integer, Double> map = new HashMap<>();
		for (int i = 0; i < points.length; i++)
		{
			Double distance = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);
			map.put(i, distance);
		}
		PriorityQueue<Map.Entry<Integer, Double>> queue = new PriorityQueue<>(
			(a, b) -> (int)(a.getValue() - b.getValue()));
		for (Map.Entry<Integer, Double> entry : map.entrySet())
		{
			queue.offer(entry);
		}
		int[][] karray = new int[k][2];
		for (int i = 0; i < k; i++)
		{
			int index = queue.poll().getKey();
			karray[i] = points[index];
		}
		return karray;
	}
	
	
	public int[][] kClosestJPT(int[][] points, int k)
	{
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]));
		for (int i = 0; i < points.length; i++)
		{
			pq.offer(points[i]);
		}
		
		for (int[] point : points) {
			pq.offer(point);
			if (pq.size() > k)
				pq.poll();
		}
		
		int[][] result = new int[k][2];
		int i = 0;
		while (!pq.isEmpty()) {
			result[i++] = pq.poll();
		}
		
		return result;
	}
}
