package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkSchedulingHoursTest {
    WorkSchedulingHours inst;
    @BeforeEach
    void setUp() {
        inst = new WorkSchedulingHours();
    }

    @Test
    void findAllSchedulings() {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1, 1, 0);
        List<Integer> list2 = Arrays.asList(0, 1, 1);
        List<Integer> list3 = Arrays.asList(1, 0, 1);
        res.add(list1);
        res.add(list2);
        res.add(list3);
        Assertions.assertEquals(res, inst.findAllSchedulings(2, 1, 3));
    }
}