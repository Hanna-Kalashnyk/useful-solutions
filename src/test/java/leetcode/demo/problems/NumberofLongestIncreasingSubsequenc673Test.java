package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberofLongestIncreasingSubsequenc673Test {
    NumberofLongestIncreasingSubsequenc673 inst;
    @BeforeEach
    void setUp() {
        inst = new NumberofLongestIncreasingSubsequenc673();

    }

    @Test
    void findNumberOfLIS() {
        int[] nums = {3, 1, 2};
        Assertions.assertEquals(1, inst.findNumberOfLIS(nums));
    }
}