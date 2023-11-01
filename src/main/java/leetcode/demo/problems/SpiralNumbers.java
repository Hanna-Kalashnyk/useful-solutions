package leetcode.demo.problems;

/*
 *  simple spiral walk around all nxm matrix from [0,0] to center
 */

import java.util.ArrayList;
import java.util.List;

class SpiralNumbers
{
    public List<String> spiralOrder(int[][] matrix)
    {
        int length = matrix[0].length;
        int height = matrix.length;

        List<String> result = new ArrayList<>();
        if ( length == 1 && height == 1 )
        {
            result.add(String.valueOf(matrix[0][0]));
            return result;
        }

        helper(matrix, 0, 0, result, length, height);
        return result;
    }

    private void helper(int[][] matrix, int n, int m, List<String> result, int length, int height)
    {
        if ( length < 1 || height < 1 )
            return;

        if ( length == 1 && height == 1 )
        {
            result.add(String.valueOf(matrix[n][m]));
            return;
        }

        if ( length > 1 && height == 1 )
        {
            oneDimentionMassive(matrix, n, m, result, length, 1);
            return;
        }

        if ( length == 1 )
        {
            oneDimentionMassive(matrix, n, m, result, 1, height);

            return;
        }
        for ( int i = 0; i < length - 1; i++ )
        {
            result.add(String.valueOf(matrix[n][m + i]));
        }
        for ( int j = 0; j < height - 1; j++ )
        {
            result.add(String.valueOf(matrix[n + j][m + length - 1]));
        }
        for ( int i = 0; i < length - 1; i++ )
        {
            result.add(String.valueOf(matrix[n + height - 1][m + length - 1 - i]));
        }
        for ( int j = 0; j < height - 1; j++ )
        {
            result.add(String.valueOf(matrix[n + height - 1 - j][m]));
        }
        helper(matrix, n + 1, m + 1, result, length - 2, height - 2);

    }

    private void oneDimentionMassive(int[][] matrix, int n, int m, List<String> result, int length, int height)
    {
        if ( height == 1 && length > 1 )
        {
            for ( int i = 0; i < length; i++ )
            {
                result.add(String.valueOf(matrix[n][m + i]));
            }
        }
        if ( height > 1 && length == 1 )
        {
            for ( int i = 0; i < height; i++ )
            {
                result.add(String.valueOf(matrix[n + i][m]));
            }
        }
    }
}