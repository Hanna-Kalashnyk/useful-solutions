class TrySpyralMatrix
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

