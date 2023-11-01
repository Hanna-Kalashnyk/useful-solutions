package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class SpiralMatrix54 {
    private static int m;
    private static int n;
    private static List res = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        m = matrix[0].length;
        n = matrix.length;
        spiral(matrix, 0);
        return res;
    }

    private void spiral(int[][] matrix, int gap) {
        while (gap < m / 2 && gap < n / 2) {
            for (int j = gap; j < m - gap; j++)
                res.add(matrix[gap][j]);
            for (int i = gap + 1 ; i < n - gap; i++)
                res.add(matrix[i][m - gap - 1]);
            for (int l = m - 2 - gap; l >= gap; l--)
                res.add(matrix[n - gap - 1][l]);
            for (int k = n - 2 - gap; k >= gap + 1; k--)
                res.add(matrix[k][gap]);
            gap++;
            spiral(matrix, gap);
        }
    }
}
