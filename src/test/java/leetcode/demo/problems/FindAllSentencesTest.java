package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindAllSentencesTest {

    FindAllSentences inst;
    @BeforeEach
    void setUp() {
        inst = new FindAllSentences();
    }

    @Test
    void findSentences() {
        String str = "Ihavenotebook";
        String[] words = {"I", "have", "note", "notebook", "book"};
        String str1 = "I have note book.";
        String str2 = "I have notebook.";
        List<String> res = new ArrayList<>();
        res.add(str1);
        res.add(str2);
        Assertions.assertEquals(res, inst.findSentences(str, words));
    }
}