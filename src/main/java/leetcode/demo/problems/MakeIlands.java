package leetcode.demo.problems;

import java.util.*;

/**
 * You are given an empty 2D binary grid grid of size m x n. The grid represents a map where 0's represent water and 1's represent land. Initially, all the cells of grid are water cells (i.e., all the cells are 0's).
 * <p>
 * We may perform an add land operation which turns the water at position into a land. You are given an array positions where positions[i] = [ri, ci] is the position (ri, ci) at which we should operate the ith operation.
 * <p>
 * Return an array of integers answer where answer[i] is the number of islands after turning the cell (ri, ci) into a land.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class MakeIlands {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[] mat = new int[m * n];
        Arrays.fill(mat, -1);
        int count = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int[] pos : positions) {
            int index = n * pos[0] + pos[1];
            if (mat[index] != -1) {
                res.add(count);
                continue;
            }
            count++;
            for (int j = 0; j < 4; j++) {
                int x = pos[0] + dx[j];
                int y = pos[1] + dy[j];
                int neighbour = n * x + y;
                if (x >= 0 && y >= 0 && x < n && y < m && mat[neighbour] != -1)
                    if (joined(mat, neighbour) != index) {
                        mat[neighbour] = index;
                        count--;
                    }
            }
            res.add(count);
        }
        return res;
    }

    public int joined(int[] mat, int neighbour) {
        while (mat[neighbour] != neighbour) {
            neighbour = mat[mat[neighbour]];
            mat[neighbour] = neighbour;
        }
        return neighbour;
    }
}

