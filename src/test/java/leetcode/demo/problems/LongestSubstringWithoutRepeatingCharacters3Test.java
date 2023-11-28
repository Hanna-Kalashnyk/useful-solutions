package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LongestSubstringWithoutRepeatingCharacters3Test {
    LongestSubstringWithoutRepeatingCharacters3 inst;
    @BeforeEach
    void setUp() {
        inst = new LongestSubstringWithoutRepeatingCharacters3();
    }

    @Test
      void lengthOfLongestSubstring() {
        String s = "Hello";
        Assertions.assertEquals(3, inst.lengthOfLongestSubstring1(s));
    }

    @Test
    void lengthOfLongestSubstring1() {
        String s = "Hello";
        Assertions.assertEquals(3, inst.lengthOfLongestSubstring1(s));
    }
}