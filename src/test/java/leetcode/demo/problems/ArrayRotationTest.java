package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayRotationTest {
    ArrayRotation inst;
    @BeforeEach
    void setUp() {
        inst = new ArrayRotation();
    }

    @Test
    void solution() {
        int[] nums = {1, 2, 3, 4};
        int[] rotated = {3, 4, 1, 2};
        Assertions.assertEquals(rotated, inst.solution(nums, 2));
    }
}