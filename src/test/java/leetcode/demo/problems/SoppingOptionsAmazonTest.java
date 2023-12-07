package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoppingOptionsAmazonTest {
    SoppingOptionsAmazon inst;
    @BeforeEach
    void setUp() {
        inst = new SoppingOptionsAmazon();
    }

    @Test
    void optionNumberCounter() {
        int[][] nums = {{2, 3}, {4, 0}, {2, 3}, {1, 2}};
        Assertions.assertEquals(4, inst.optionNumberCounter(nums, 10));
    }
}