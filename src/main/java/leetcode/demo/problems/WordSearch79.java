package leetcode.demo.problems;
 /*
 Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */

public class WordSearch79 {
    char[] chars;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int index = 0;
        visited = new boolean[board.length][board[0].length];
        chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) &&
                        findNext(board, i, j, 0, visited)) return true;
            }
        }
        return false;
    }

    private boolean findNext(char[][] board, int i, int j, int index, boolean[][] visited) {
        if (index == chars.length) {
            return true; // Word found
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != chars[index]) {
            return false;
        }

        visited[i][j] = true;

        // Explore in all four directions
        boolean found = findNext(board, i + 1, j, index + 1, visited)
                || findNext(board, i - 1, j, index + 1, visited)
                || findNext(board, i, j + 1, index + 1, visited)
                || findNext(board, i, j - 1, index + 1, visited);

        visited[i][j] = false; // Backtrack
        return found;
    }
}