package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FindMaxZeroGapsAfterToBinaryConvertionTest {
    FindMaxZeroGapsAfterToBinaryConvertion inst;
    @BeforeEach
    void setUp() {
        inst = new FindMaxZeroGapsAfterToBinaryConvertion();
    }

    @Test
    void solution() {
        Assertions.assertEquals(5, inst.solution(1041));
    }
}