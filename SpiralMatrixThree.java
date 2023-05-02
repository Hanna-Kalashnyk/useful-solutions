//You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, 
//and the southeast corner is at the last row and column.

//You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, 
//we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid

public class SpiralMatrixThree
{
    int idx;
    int[][] ret;

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart)
    {
        int r = rStart, c = cStart, len = 1;
        ret = new int[rows * cols][2];
        while ( idx < (rows * cols) )
        {
            for ( int k = 0; k < len; k++ )
                add(r, c++, rows, cols);
            for ( int k = 0; k < len; k++ )
                add(r++, c, rows, cols);
            len++;
            for ( int k = 0; k < len; k++ )
                add(r, c--, rows, cols);
            for ( int k = 0; k < len; k++ )
                add(r--, c, rows, cols);
            len++;
        }
        return ret;
    }


    private void add(int r, int c, int R, int C)
    {
        if ( r >= R || r < 0 || c >= C || c < 0 )
            return;
        ret[idx][0] = r;
        ret[idx++][1] = c;
    }
}
