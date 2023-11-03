package leetcode.demo.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordSearch79Test {
    private static WordSearch79 inst;

    @BeforeEach
    void setUp() {
        inst = new WordSearch79();
    }

    @Test
    void exist() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCD";
        Assertions.assertEquals(false, inst.exist(board, word));
    }

    @Test
    void exist1() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        Assertions.assertEquals(false, inst.exist(board, word));
    }

    @Test
    void exist2() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        Assertions.assertEquals(true, inst.exist(board, word));
    }
    @Test
    void exist3() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        Assertions.assertEquals(true, inst.exist(board, word));
    }
}