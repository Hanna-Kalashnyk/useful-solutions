package leetcode.demo.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CavitiinGridFacebook {
    public static List<String> cavityMap(List<String> grid) {
        int m = grid.get(0).length();
        int n = grid.size();
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = grid.get(i).charAt(j);
            }
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                int curr = (int) matrix[i][j];
                if(matrix[i - 1][j] == 'X' || matrix[i + 1][j] == 'X' || matrix[i][j - 1] == 'X' || matrix[i][j + 1] == 'X')  continue;
                if((int)matrix[i - 1][j] < curr && (int)matrix[i + 1][j] < curr && (int)matrix[i][j - 1] < curr && (int)matrix[i][j + 1] < curr)  matrix[i][j] = 'X';
            }
        }

        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < m; j++) {
                sb.append(matrix[i][j]);
            }
            grid.set(i, sb.toString());
        }
        return grid;
    }
}

