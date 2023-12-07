package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountSwapsAtBubleSortingAmazonTest {
    CountSwapsAtBubleSortingAmazon inst;
    @BeforeEach
    void setUp() {
        inst = new CountSwapsAtBubleSortingAmazon();
    }

    @Test
    void swapCount() {
        int[] arr = {1, 4, 3, 2, 5};
        Assertions.assertEquals(3, inst.swapCount(arr));
    }
}