package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptimizingBoxWeightAmazonTest {
    OptimizingBoxWeightAmazon inst;
    @BeforeEach
    void setUp() {
        inst = new OptimizingBoxWeightAmazon();
    }

    @Test
    void minimalHeaviestSetA() {
        int[] res = {6, 7};
        int[] A = {3,7,5,6,2};
        Assertions.assertEquals(res, inst.minimalHeaviestSetA(A));
    }
}