package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFleet853Test {
 CarFleet853 inst;
    @BeforeEach
    void setUp() {
        inst = new CarFleet853();
    }

    @Test
    void carFleet() {
        int[] position = {6, 8};
        int[] speed = {3, 2};
        Assertions.assertEquals(2, inst.carFleet1(10, position, speed));
    }
}