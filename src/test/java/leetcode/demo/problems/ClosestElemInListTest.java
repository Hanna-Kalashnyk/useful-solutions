package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClosestElemInListTest {
    ClosestElemInList inst;
    @BeforeEach
    void setUp() {
        inst = new ClosestElemInList();
    }

    @Test
    void findClosest() {
        List ar = Arrays.asList(1, 2, -2, 6, 8, 5, 10);
        Assertions.assertEquals( 1, inst.findClosestOn(ar, 0));
    }
}