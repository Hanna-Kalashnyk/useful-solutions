package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinfPairsMetaTest {
    FinfPairsMeta inst;
    @BeforeEach
    void setUp() {
        inst = new FinfPairsMeta();
    }

    @Test
    void findPairs() {
        int[] nums = {1, 2, 3};
        Assertions.assertEquals(6, inst.findPairs(nums));
    }

    @Test
    void findPairs2() {
        int[] nums = {1, 2, 3, 4};
        Assertions.assertEquals(12, inst.findPairMap(nums));
    }

    @Test
    void findPairs3() {
        int[] nums = {3, 1, 2, 3};
        Assertions.assertEquals(6, inst.findPairMap(nums));
    }
}