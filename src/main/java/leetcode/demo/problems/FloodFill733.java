//An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
//
//You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
//
//To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
//
//Return the modified image after performing the flood fill.
package leetcode.demo.problems;

public class FloodFill733
{
	public int[][] floodFill(int[][] image, int sr, int sc, int color)
	{
		if (image[sr][sc] == color)
			return image;
		floodFunc(image, sr, sc, color, image[sr][sc]);
		return image;
	}
	
	
	private void floodFunc(int[][] image, int sr, int sc, int color, int oldColor)
	{
		if (image[sr][sc] == oldColor)
		{
			image[sr][sc] = color;
			
			if (sr > 0)
			{
				floodFunc(image, sr - 1, sc, color, oldColor);
			}
			if (sr < image.length - 1)
			{
				floodFunc(image, sr + 1, sc, color, oldColor);
			}
			if (sc > 0)
			{
				floodFunc(image, sr, sc - 1, color, oldColor);
			}
			if (sc < image[0].length - 1)
			{
				floodFunc(image, sr, sc + 1, color, oldColor);
			}
		}
	}
}
