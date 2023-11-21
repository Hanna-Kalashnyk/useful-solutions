package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarray53Test {
MaximumSubarray53 inst;
    @BeforeEach
    void setUp() {
    inst = new MaximumSubarray53();
    }

    @Test
    void maxSubArray2() {
        int[] nums ={0, 2,3, -5, -6, 2, 67, -5, -2, 77, -1, -2};
        Assertions.assertEquals(139, inst.maxSubArray2(nums));
    }

    @Test
    void maxSubArray3() {
        int[] nums ={ -2, -3, -5, -6, -67, -5, -2, -77, -2};
        Assertions.assertEquals(-2, inst.maxSubArray2(nums));
    }
}