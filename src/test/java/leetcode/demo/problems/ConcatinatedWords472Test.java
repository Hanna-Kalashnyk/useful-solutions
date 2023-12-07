package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcatinatedWords472Test {
    ConcatinatedWords472 inst;
    @BeforeEach
    void setUp() {
        inst = new ConcatinatedWords472();
    }

    @Test
    void findAllConcatenatedWordsInADict() {
        String[] words = {"a", "aaa", "aa", "ab"};
        String[] res = {"aaa", "aa"};
        Assertions.assertEquals(res, inst.findAllConcatenatedWordsInADict(words));
    }
}