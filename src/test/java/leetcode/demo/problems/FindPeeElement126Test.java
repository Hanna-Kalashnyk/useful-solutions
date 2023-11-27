package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPeeElement126Test {
    FindPeeElement126 inst;

    @BeforeEach
    void setUp() {
        inst = new FindPeeElement126();
    }

    @Test
    void findPeekElement() {
        int[] nums = {1, 2, 3, 4, 3, 2, 1};
        Assertions.assertEquals(3, inst.findPeekElement(nums));
    }

    @Test
    void findCorner() {
        int[] nums = {4, 2, 3, 4, 3, 2, 1};
        Assertions.assertEquals(0, inst.findPeekElement(nums));
    }

    @Test
    void findEnd(){
        int[] nums = {1,2,3,4,4,4,6};
        Assertions.assertEquals(6, inst.findPeekElement(nums));
    }
}