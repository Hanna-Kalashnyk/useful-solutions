package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharacters3Test {
    LongestSubstringWithoutRepeatingCharacters3 inst;
    @BeforeEach
    void setUp() {
        inst = new LongestSubstringWithoutRepeatingCharacters3();
    }

    @Test
    void lengthOfLongestSubstring() {
        s = "Hello";
        Assertions.assertEquals(3, inst.lengthOfLongestSubstring1(s));
    }

    @Test
    void lengthOfLongestSubstring1() {
        s = "Hello";
        Assertions.assertEquals(3, inst.lengthOfLongestSubstring1(s));
    }
}