package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Search2DMatrix74Test {
    Search2DMatrix74 inst;
    @BeforeEach
    void setUp() {
        inst  =  new Search2DMatrix74();
    }

    @Test
    void searchMatrix() {
        int[][] nums = {{1}, {3}};
        Assertions.assertEquals(true, inst.searchMatrix(nums, 3));
    }
}