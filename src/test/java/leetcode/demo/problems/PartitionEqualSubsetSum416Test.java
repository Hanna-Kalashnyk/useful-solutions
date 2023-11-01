package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartitionEqualSubsetSum416Test {
    PartitionEqualSubsetSum416 inst;
    @BeforeEach
    void setUp() {
        inst = new PartitionEqualSubsetSum416();
    }

    @Test
    void canPartitionTetTrue() {
        int[] nums = {1, 2, 3, 4, 2};
        boolean expect = true;
        Assertions.assertEquals(expect, inst.canPartition(nums));
    }

    @Test
    void canPartitionTetFalse() {
        int[] nums = {1, 2, 3, 4, 2, 1};
        boolean expect = false;
        Assertions.assertEquals(expect, inst.canPartition(nums));
    }
}