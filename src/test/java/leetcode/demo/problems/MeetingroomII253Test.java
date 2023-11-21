package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeetingroomII253Test {
    MeetingroomII253 inst;
    @BeforeEach
    void setUp() {
        inst = new MeetingroomII253();
    }

    @Test
    void roomNumber() {
        int[][] example = {{0, 2}, {3, 5}, {2, 6}, {4, 5}};
        Assertions.assertEquals(3, inst.roomNumber(example));
    }
}