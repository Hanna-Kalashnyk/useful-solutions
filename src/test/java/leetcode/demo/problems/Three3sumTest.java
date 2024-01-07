package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Three3sumTest {
    Three3sum inst;
    @BeforeEach
    void setUp() {
        inst = new Three3sum();
    }

    @Test
    void threeSumTest() {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(-1,-1, 2));
        res.add(Arrays.asList(-1,0, 1));
        Assertions.assertEquals(res, inst.threeSum(nums));
    }
}