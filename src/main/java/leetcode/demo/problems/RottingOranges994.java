package leetcode.demo.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * <p>
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */
public class RottingOranges994 {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        int countFresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }
        if (countFresh == 0) return 0;
        if (queue.isEmpty()) return -1;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int e = 0; e < size; e++) {
                int[] dot = queue.poll();
                boolean rot = false;
                for (int[] dir : directions) {
                    int i = dot[0] + dir[0];
                    int j = dot[1] + dir[1];

                    if (i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        queue.offer(new int[]{i, j});
                        countFresh -= 1;
                        rot = true;
                    }
                }
                if (rot) res++;
            }
        }
        res = countFresh == 0 ? res : -1;
        return res;
    }
}
//        private static int rotten ( int[][] grid, int i, int j, int n, int m, int count, int countFresh){
//            int currres = 0;
//            if (i > 0 && grid[i - 1][j] == 1) {
//                grid[i - 1][j] = 2;
//                currres = Math.max(rotten(grid, i - 1, j, n, m, count + 1), count + 1);
//            }
//            if (i < n - 1 && grid[i + 1][j] == 1) {
//                grid[i + 1][j] = 2;
//                currres = Math.max(rotten(grid, i + 1, j, n, m, count + 1), count + 1);
//            }
//            if (j > 0 && grid[i][j - 1] == 1) {
//                grid[i][j - 1] = 2;
//                currres = Math.max(rotten(grid, i, j - 1, n, m, count + 1), count + 1);
//            }
//            if (j < m - 1 && grid[i][j + 1] == 1) {
//                grid[i][j + 1] = 2;
//                currres = Math.max(rotten(grid, i, j + 1, n, m, count + 1), count + 1);
//
//            }
//            return Math.max(currres, count);
//        ¬}
