package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindKClosestElements658Test {
    FindKClosestElements658 inst;
    @BeforeEach
    void setUp() {
        inst = new FindKClosestElements658();
    }

    @Test
    void findClosestElements() {
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Assertions.assertEquals(list, inst.findClosestElements(arr, 4, -1));
    }

    @Test
    void findClosestElements1() {
        int[] arr = {1,1,1,10,10,10};
        List<Integer> res = Arrays.asList(10);
        Assertions.assertEquals(res, inst.findClosestElements(arr, 1, 9));
    }
}