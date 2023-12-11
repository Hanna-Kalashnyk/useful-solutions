package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGame55Test {
    JumpGame55 inst;
    @BeforeEach
    void setUp() {
        inst = new JumpGame55();
    }

    @Test
    void canJump() {
        int[] nums = {1, 2, 3, 0, 0, 1, 0};
        Assertions.assertEquals(true , inst.canJump(nums));
    }
}