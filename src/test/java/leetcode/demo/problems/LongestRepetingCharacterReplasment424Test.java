package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class LongestRepetingCharacterReplasment424Test {
    LongestRepetingCharacterReplasment424 inst;
    @BeforeEach
    void setUp() {
        inst = new LongestRepetingCharacterReplasment424();
    }

    @Test
    void characterReplacement() {
        String s = "DFAAGHAKMNB";
        Assertions.assertEquals(5, inst.characterReplacement(s, 2));
    }
}