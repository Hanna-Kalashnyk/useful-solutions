package leetcode.demo.problems;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage48 {
    public void rotate(int[][] matrix) {
        indexSwitch(matrix);
        columnSwitch(matrix);
    }

    private void indexSwitch(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void columnSwitch(int[][] matrix) {
        int lCol = 0;
        int rCol = matrix.length - 1;
        while (lCol < rCol) {
            for (int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][rCol];
                matrix[i][rCol] = matrix[i][lCol];
                matrix[i][lCol] = temp;
            }
            lCol++;
            rCol--;
        }
    }
}