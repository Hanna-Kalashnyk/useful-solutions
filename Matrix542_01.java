//Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
//The distance between two adjacent cells is 1.
package leetcode;

public class Matrix542_01
{
	public int[][] updateMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++)
		{
			for (int j = 0; j < mat[i].length; j++)
			{
				mat[i][j] = minStepsToZero(mat, i, j);
			}
		}return mat;
	}
	
	private int minStepsToZero(int[][] mat, int i, int j)
	{
		if (mat[i][j] == 0) return 0;
		else {
		int a = 0,b = 0,c = 0,d = 0;
		
		if(i > 0) a = minStepsToZero(mat, i-1, j) + 1;
		if(j > 0) b = minStepsToZero(mat, i, j-1) + 1;
		if(i < mat.length-1) c = minStepsToZero(mat, i, j+1) + 1;
		if(j < mat[i].length-1) d = minStepsToZero(mat, i, j+1) + 1;
		int min = Math.min(Math.min(a, b), Math.min(c, d));
		return min;}
	}
}
