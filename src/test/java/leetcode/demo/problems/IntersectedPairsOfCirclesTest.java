package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntersectedPairsOfCirclesTest {
    IntersectedPairsOfCircles inst;
    @BeforeEach
    void setUp() {
        inst = new IntersectedPairsOfCircles();
    }

    @Test
    void solution() {
        int[] nums = {1, 5, 2, 1, 4, 0};
        Assertions.assertEquals(11, inst.solution(nums));
    }
}