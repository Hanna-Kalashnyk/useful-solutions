package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
 * <p>
 * You must do it in place.
 */
public class SetLineZirous73 {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<int[]> riestr = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    int[] zeros = new int[2];
                    zeros[0] = i;
                    zeros[1] = j;
                    riestr.add(zeros);
                }
            }
        }
        for (int[] zero : riestr) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[zero[0]][j] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][zero[1]] = 0;
            }
        }
    }
}