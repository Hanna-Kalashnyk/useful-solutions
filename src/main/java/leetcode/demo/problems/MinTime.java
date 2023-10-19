//On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi].
// Return the minimum time in seconds to visit all the points in the order given by points.
//
//You can move according to these rules:
//
//In 1 second, you can either:
//move vertically by one unit,
//move horizontally by one unit, or
//move diagonally sqrt(2) units (in other words, move one unit vertically then
// one unit horizontally in 1 second).
//You have to visit the points in the same order as they appear in the array.
//You are allowed to pass through points that appear later in the order,
// but these do not count as visits.
package leetcode.demo.problems;

public class MinTime
{
	public int minTimeToVisitAllPoints(int[][] points)
	{
		int[] start = new int[] { 0, 0 };
		double time = 0;
		for (int i = 1; i < points.length; i++)
		{
			int xdiff = points[i][0] - points[i - 1][0];
			int ydiff = points[i][1] - points[i - 1][1];
			if (xdiff == 0 || ydiff == 0 || xdiff == ydiff)
			{
				time += (double)Math.sqrt(Math.pow(xdiff, 2) + Math.pow(ydiff, 2));
				
				continue;
			}
			time += xdiff - ydiff > 0 ? xdiff - ydiff : ydiff - xdiff;
			time += (double)Math.sqrt(Math.min(Math.pow(xdiff, 2), Math.pow(ydiff, 2)));
		}
		return (int)time;
	}
}
