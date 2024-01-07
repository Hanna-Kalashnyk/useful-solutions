package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BanketSeparationTest {
    BanketSeparation inst;

    @BeforeEach
    void setUp() {
        inst = new BanketSeparation();
    }

    @Test
    void isBipatiteGraph() {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        set1.add(2);
        set1.add(3);
        set1.add(5);
        set2.add(4);
        set2.add(5);
        map.put(1, set1);
        map.put(3, set2);

        int[] res = {1, 3};
        Assertions.assertEquals(false, inst.couldSeparate(map));
    }
}