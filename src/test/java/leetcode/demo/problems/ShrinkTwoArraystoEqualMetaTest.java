package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShrinkTwoArraystoEqualMetaTest {
 ShrinkTwoArraystoEqualMeta inst;
    @BeforeEach
    void setUp() {
        inst = new ShrinkTwoArraystoEqualMeta();
    }

    @Test
    void main() {


    }

    @Test
    void foundEqualArraysLength() {
        int[] arr = {0, 1, 2, 3, 4, 0, 0, 1, 0, 2, 0};
        int[] brr = {1, 2, 7, 3};
        Assertions.assertEquals(4, inst.foundEqualArraysLength(0, 0, arr, brr, 0));
    }
}