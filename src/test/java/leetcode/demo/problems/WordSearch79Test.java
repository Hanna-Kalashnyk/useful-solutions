package leetcode.demo.problems;

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
        assertFalse(inst.exist(board, word));
    }

    @Test
    void exist1() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        assertFalse(inst.exist(board, word));
    }

    @Test
    void exist2() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        assertTrue(inst.exist(board, word));
    }
    @Test
    void exist3() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        assertTrue(inst.exist(board, word));
    }
}