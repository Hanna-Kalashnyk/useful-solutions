package leetcode.demo.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnightChessDialDiffNumbersNLength {
    int res = 0;
    Map<Integer, Integer> neiboursNumber = new HashMap<>();
    Map<Integer, List<Integer>> neibours = new HashMap<>();

    public int knightWays(int n, int start) {
        while (n > 0) {
            res += neiboursNumber.get(start);
            n--;
            for (Integer neibor : neibours.get(start)) {
                knightWays(n - 1, neibor);
            }
        }
        return res;
    }
}
