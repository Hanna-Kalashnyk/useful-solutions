package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

class SetLineZirous73Test {

    SetLineZirous73 inst;

    @BeforeEach
    void setUp() {
        inst = new SetLineZirous73();
    }


//    public String toString1(int[][] matrix) {
//        String row = null;
//        String res = "[";
//        for (int i = 0; i < matrix.length; i++) {
//            row = "[";
//
//            for (int j = 0; j < matrix[0].length - 1; j++) {
//                row = row + matrix[i][j] + ", ";
//            }
//            row = row + matrix[i][matrix[0].length - 1] + "]";
//            res = res + row;
//            if (i < matrix.length - 1)
//                res = res + ", ";
//        }
//        res = res + "]";
//        return res;
//    }

//    @Test
//    void setZeroes1() {
//        int[][] matrix = {{1, 0, 1}, {1, 1, 1}, {2, 0, 9}};
//        int[][] expect = {{0, 0, 0}, {1, 0, 1}, {0, 0, 0}};
//        inst.setZeroes(matrix);
//        assertEquals(toString1(expect), toString1(matrix));
//    }
    // assertJ lib will throw different exceptions - not acceptabl[ss   ``e.
    @Test
    void setZeroes2() {
        int[][] matrix = {{1, 0, 1}, {1, 1, 1}, {2, 0, 9}};
        int[][] expect = {{0, 0, 0}, {1, 0, 1}, {0, 0, 0}};
        inst.setZeroes(matrix);
        assertThat(Arrays.deepEquals(expect, matrix)).isTrue();
    }
    @Test
    void setZeroes3() {
        int[][] matrix = {{1, 0, 1}, {1, 1, 1}, {2, 0, 9}};
        int[][] expect = {{0, 0, 0}, {1, 0, 1}, {0, 0, 0}};
        inst.setZeroes(matrix);
        Assertions.assertEquals(Arrays.deepToString(expect), Arrays.deepToString(matrix));
    }
}