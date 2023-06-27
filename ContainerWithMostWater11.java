//You are given an integer array height of length n.
// There are n vertical lines drawn such that the two endpoints
// of the ith line are (i, 0) and (i, height[i]).
//
//Find two lines that together with the x-axis form a container,
// such that the container contains the most water.
//
//Return the maximum amount of water a container can store.
//
//Notice that you may not slant the container.
package leetcode;

public class ContainerWithMostWater11
{
	public int maxArea(int[] height)
	{
		int min = 0;
		int max = 0;
		int volume = 0;
		int l = 0;
		int r = height.length-1;
		while (l < r)
		{
			min = Math.min(height[l], height[r]);
			volume = min * (r - l);
			max = Math.max(max, volume);
			if (height[l] < height[r])
			{l++;} else
			if (height[r] < height[l])
			{r--;}else
			if (height[l] == height[r])
			{
				l++;
				r--;
			}
		}return max;
	}
}
