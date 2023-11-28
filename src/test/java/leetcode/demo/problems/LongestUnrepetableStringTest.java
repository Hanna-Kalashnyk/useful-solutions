package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class LongestUnrepetableStringTest {
    LongestUnrepetableString inst;
    @BeforeEach
    void setUp() {
        inst = new LongestUnrepetableString();
    }

    @Test
    void characterReplacement() {
        String s = "VAAFDTE";
        Assertions.assertEquals(5, inst.lengthOfLongestSubstring(s));
    }
}