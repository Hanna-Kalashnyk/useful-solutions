package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedArray33Test {
    SearchInRotatedArray33 inst;
    @BeforeEach
    void setUp() {
        inst = new SearchInRotatedArray33();
    }

    @Test
    void search() {
        int[] nums = {4,5,1,2,3};
        Assertions.assertEquals(2, inst.search(nums, 1));
    }
    @Test
    void search1() {
        int[] nums = {4,5,6,7,0,1,2};
        Assertions.assertEquals(4, inst.search(nums, 0));
    }
    @Test
    void search2() {
        int[] nums = {3, 5, 1};
        Assertions.assertEquals(0, inst.search(nums, 3));
    }
}