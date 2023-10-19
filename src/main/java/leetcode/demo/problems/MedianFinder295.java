package leetcode.demo.problems;

import java.util.PriorityQueue;

public class MedianFinder295
{
	
	PriorityQueue<Integer> smallQueue;
	PriorityQueue<Integer> bigQueue;
	
	MedianFinder295()
	{
		smallQueue = new PriorityQueue<>((a, b) -> (b - a));
		bigQueue = new PriorityQueue<>((a, b) -> (a - b));
	}
	
	public void addNum(int num)
	{
		this.smallQueue.add(num);
		if (smallQueue.size() - bigQueue.size() > 1 || !bigQueue.isEmpty() && smallQueue.peek() > bigQueue.peek())
		{
			bigQueue.offer(smallQueue.poll());
		}
		if (bigQueue.size() - smallQueue.size() > 1)
		{
			smallQueue.offer(bigQueue.poll());
		}
	}
	
	public double findMedian()
	{
		if (smallQueue.size() > bigQueue.size())
			return (double)smallQueue.peek();
		else if (smallQueue.size() == bigQueue.size())
			return (double)(smallQueue.peek() + bigQueue.peek()) / 2;
		else
			return (double)bigQueue.peek();
	}
}