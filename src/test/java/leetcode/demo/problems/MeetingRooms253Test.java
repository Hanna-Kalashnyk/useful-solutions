package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRooms253Test {
    MeetingRooms253 inst;
    @BeforeEach
    void setUp() {
        inst = new MeetingRooms253();
    }

    @Test
    void minMeetingRooms() {
        int[][] nums = {{5,8},{6,8}};
        Assertions.assertEquals(2, inst.minMeetingRooms(nums));
    }
}