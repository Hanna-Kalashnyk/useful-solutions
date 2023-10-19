package leetcode.demo.problems;

public class BallFall
{
    public int[] findBall(int[][] grid)
    {
        int width = grid[0].length;
        int height = grid.length;
        int[] result = new int[width];
        int enter = 1;
        for ( int number = 0; number < width; number++ )
        {
            result[number] = ball(grid, 0, number, 1, result, width, height);
        }
        return result;
    }

    private int ball(int[][] grid, int i, int j, int enter, int[] result, int width, int height)
    {
        if ( grid[i][j] == 1 )
        {
            if ( enter == 1 )
            {
                if ( j < width )
                {
                    ball(grid, i, j + 1, 4, result, width, height);
                }
                else
                {
                    return -1;
                }
            }
            if ( enter == 4 )
            {
                if ( i < height - 1 )
                {
                    ball(grid, i + 1, j, 1, result, width, height);
                }
                else
                {
                    return j;
                }
            }
            if ( enter == 2 )
                return -1;
        }

        if ( grid[i][j] == -1 )
        {
            if ( enter == 1 )
            {
                if ( j > 0 )
                {
                    ball(grid, i, j - 1, 2, result, width, height);
                }
                else
                {
                    return -1;
                }
            }
            if ( enter == 2 )
            {
                if ( i < height - 1 )
                {
                    ball(grid, i + 1, j, 1, result, width, height);
                }
                else
                {
                    return j;
                }
            }
            if ( enter == 4 )
                return -1;
        }
        return -1;
    }

}    