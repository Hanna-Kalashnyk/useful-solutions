import java.util.ArrayList;
import java.util.List;

class SpiralNumbers
{
    public List<Integer> spiralOrder(int[][] matrix)
    {
        int length = matrix[0].length;
        int height = matrix.length;

        List<String> result = new ArrayList<>();
        if ( length == 1 && height == 1 )
        {
            result.add(matrix[0][0]);
            return result;
        }

        helper(matrix, 0, 0, result, length, height);
        return result;
    }

    private void helper(int[][] matrix, int n, int m, List<Integer> result, int length, int height)
    {
        if ( length < 1 || height < 1 )
            return;

        if ( length == 1 && height == 1 )
        {
            result.add(matrix[n][m]);
            return;
        }

        if ( length > 1 && height == 1 )
        {
            oneDimentionMassive(matrix, n, m , result, length, 1);
            return;
        }

        if ( length == 1 && height > 1 )
        {
            oneDimentionMassive(matrix, n, m , result, 1, height);

            return;
        }
        for ( int i = 0; i < length - 1; i++ )
        {
            result.add(matrix[n][m + i]);
        }
        for ( int j = 0; j < height - 1; j++ )
        {
            result.add(matrix[n + j][m + length - 1]);
        }
        for ( int i = 0; i < length - 1; i++ )
        {
            result.add(matrix[n + height - 1][m + length - 1 - i]);
        }
        for ( int j = 0; j < height - 1; j++ )
        {
            result.add(matrix[n + height - 1 - j][m]);
        }
        helper(matrix, n + 1, m + 1, result, length - 2, height - 2);

    }

    private void oneDimentionMassive(int[][] matrix, int n, int m, List<Integer> result, int length, int height)
    {
        if ( height == 1 && length > 0 )
        {
            for ( int i = 0; i < length; i++ )
            {
                result.add(matrix[n][m + i]);
            }
        }
        if ( height > 0 && length == 1 )
        {
            for ( int i = 0; i < height; i++ )
            {
                result.add(matrix[n + i][m]);
            }
        }
    }

    private static void printSpiralByIndexess(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd)
    {
        if ( rowStart > rowEnd || colStart > colEnd )
        {
            return; // base case: we have printed all elements
        }

        // print the first row from the remaining rows
        for ( int i = colStart; i <= colEnd; i++ )
        {
            System.out.print(matrix[rowStart][i] + " ");
        }
        // traverse down to the last row
        for ( int i = rowStart + 1; i <= rowEnd; i++ )
        {
            System.out.print(matrix[i][colEnd] + " ");
        }

        // print the last row from the remaining rows, if there is one
        if ( rowStart != rowEnd )
        {
            for ( int i = colEnd - 1; i >= colStart; i-- )
            {
                System.out.print(matrix[rowEnd][i] + " ");
            }
        }

        // print the first column from the remaining columns, if there is one
        if ( colStart != colEnd )
        {
            for ( int i = rowEnd - 1; i > rowStart; i-- )
            {
                System.out.print(matrix[i][colStart] + " ");
            }
        }

        // call the method recursively to print the remaining matrix
        printSpiralByIndexes(matrix, rowStart + 1, rowEnd - 1, colStart + 1, colEnd - 1);
    }

    private static void printSpiralInd(int rows, int cols, int rStart, int cStart)
    {
        int[] matrix = new int[Math.multiplyExact(rows, cols)];
        matrix[0] = new Pair(rStart,cStart);

    }


    printSpiralByIndexes(matrix, rows, cols, rStart-1, cStart-1, rStart+1, cStart+1);}

        private static void printSpiralByIndexes(int[] matrix, int rows, int cols, int rStart, int cStart, int rEnd, int cEnd){

        if ( 0 > rStart && rowEnd && colStart > colEnd )
        {
            return; // base case: we have printed all elements
        }

        // print the first row from the remaining rows
        for ( int i = colStart; i <= colEnd; i++ )
        {
            System.out.print(matrix[rowStart][i] + " ");
        }
        // traverse down to the last row
        for ( int i = rowStart + 1; i <= rowEnd; i++ )
        {
            System.out.print(matrix[i][colEnd] + " ");
        }

        // print the last row from the remaining rows, if there is one
        if ( rowStart != rowEnd )
        {
            for ( int i = colEnd - 1; i >= colStart; i-- )
            {
                System.out.print(matrix[rowEnd][i] + " ");
            }
        }

        // print the first column from the remaining columns, if there is one
        if ( colStart != colEnd )
        {
            for ( int i = rowEnd - 1; i > rowStart; i-- )
            {
                System.out.print(matrix[i][colStart] + " ");
            }
        }

        // call the method recursively to print the remaining matrix
        printSpiralByIndexes(matrix, rowStart + 1, rowEnd - 1, colStart + 1, colEnd - 1);
    }


       private printIfInMatrix(int x, int y, int width, int height, List<string> result){
    if (x < height && x >=0 && y >= 0 && y < width)

           {
               result.add("[" + x + "," + y +"]");
           }
       }
    }