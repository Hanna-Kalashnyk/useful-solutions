package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindAllAnagramsinString432Test {
    FindAllAnagramsinString432 finder;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        finder = new FindAllAnagramsinString432();
    }

    @Test
    void findAnagramsSergiiTest() {
        List<Integer> expected = List.of(0, 1);
        Assertions.assertEquals(expected,finder.findAnagramsSergii("abcadc", "cba"));
    }

    @Test
    void findAnagramsTest(){
        List<Integer> expected = List.of(0,1,2,6);
        Assertions.assertEquals(expected, finder.findAnagrams("ababssba", "ba"));
    }
}