package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * <p>
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice,
 * and the combinations may be returned in any order.
 */
public class CombinationSumIII216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        Set<List<Integer>> set = new HashSet<>();
        track(1, n, new ArrayList<Integer>(), set, k);
        return new ArrayList<>(set);
    }

    private void track(int start, int target, ArrayList<Integer> list, Set<List<Integer>> rez, int k) {
        if (target < 0 || k < 0) return;
        if (target == 0 && k == 0) {
            rez.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < 10; i++) {
            list.add(i);
            k--;
            track(i + 1, target - i, list, rez, k);
            k++;
            list.remove(list.size() - 1);
        }
    }
}
