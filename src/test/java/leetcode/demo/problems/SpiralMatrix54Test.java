package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SpiralMatrix54Test {
SpiralMatrix54 inst;
    @BeforeEach
    void setUp() {
        inst = new SpiralMatrix54();
    }
    @Test
    void test1(){
        int[][] matrix = {{1, 2, 3}, {6, 5, 4}};
        List<Integer> expected =  List.of(1, 2, 3, 4, 5, 6);
        Assertions.assertEquals(expected, inst.spiralOrder(matrix));
    }
}