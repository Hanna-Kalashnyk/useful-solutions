//The median is the middle value in an ordered integer list.
// If the size of the list is even, there is no middle value,
// and the median is the mean of the two middle values.
//
//For example, for arr = [2,3,4], the median is 3.
//For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
//Implement the MedianFinder class:
//
//MedianFinder() initializes the MedianFinder object.
//void addNum(int num) adds the integer num from the data stream to the data structure.
//double findMedian() returns the median of all elements so far.
// Answers within 10-5 of the actual answer will be accepted.
package leetcode.demo.problems;

import java.util.ArrayList;

public class FindMedianfromDataStream295
{
	private ArrayList<Integer> list;
	
	public FindMedianfromDataStream295()
	{
		this.list = new ArrayList<>();
	}
	
	public void addNum(int num)
	{
		if (list.size() == 0)
		{
			this.list.add(num);
		}
		else
		{
			boolean putInPlace = false;
			for (int i = 0; i < list.size(); i++)
			{
				if (list.get(i) > num)
				{
					list.add(i, num);
					putInPlace = true;
				}
			}
			if (putInPlace == false)
			{
				list.add(num);
			}
		}
	}
	
	public double findMedian()
	{
		
		int listSize = list.size();
		if (listSize == 0)
			return 0;
		if (listSize % 2 == 0)
		{
			return (double) (list.get(listSize / 2) + list.get(listSize / 2 - 1))/2;
		}
		else
		{
			return list.get(listSize / 2);
		}
	}
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
