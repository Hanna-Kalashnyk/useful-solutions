package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class RottingOranges994Test {
    RottingOranges994 rot;
    @BeforeEach
    void setUp() {
        rot = new RottingOranges994();
    }

    @Test
    void orangesRotting() {
        int expected = 1;
        int[][] example = {{1, 2}, {0, 1}};
        Assertions.assertEquals(expected, rot.orangesRotting(example));
    }
}