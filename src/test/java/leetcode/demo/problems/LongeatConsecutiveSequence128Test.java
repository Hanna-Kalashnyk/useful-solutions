package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LongeatConsecutiveSequence128Test {
    LongeatConsecutiveSequence128 inst;

    @BeforeEach
    void setUp() {
        inst = new LongeatConsecutiveSequence128();
    }

    @Test
    void longestConsecutive() {
        int[] nums = {1, 2, 2, 4, 3, 50, 51, 52, 0};
        Assertions.assertEquals(5, inst.longestConsecutive(nums));
    }
}