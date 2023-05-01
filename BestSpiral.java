package leetcode;

import java.util.List;

public class BestSpiral
{
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> list = new ArrayList<>();
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while ( startRow <= endRow && startCol <= endCol )
        {
            // traverse right
            for ( int i = startCol; i <= endCol; i++ )
            {
                list.add(matrix[startRow][i]);
            }
            startRow++;

            // traverse down
            for ( int i = startRow; i <= endRow; i++ )
            {
                list.add(matrix[i][endCol]);
            }
            endCol--;

            // traverse left
            if ( startRow <= endRow )
            {
                for ( int i = endCol; i >= startCol; i-- )
                {
                    list.add(matrix[endRow][i]);
                }
                endRow--;
            }

            // traverse up
            if ( startCol <= endCol )
            {
                for ( int i = endRow; i >= startRow; i-- )
                {
                    list.add(matrix[i][startCol]);
                }
                startCol++;
            }
        }

        return list;
    }
}