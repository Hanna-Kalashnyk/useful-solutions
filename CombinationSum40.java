
//Given a collection of candidate numbers (candidates) and a target number (target),
// find all unique combinations in candidates where the candidate numbers sum to target.
//
//Each number in candidates may only be used once in the combination.
//
//Note: The solution set must not contain duplicate combinations.
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rez = new ArrayList<>();
        compositionSum(rez, candidates, target, 0, new ArrayList<Integer>());
        return rez;
    }

    private void compositionSum(List<List<Integer>> rez, int[] candidates, int target, int index, List<Integer> tempList) {
        if (tempList.stream().mapToInt(Integer::valueOf).sum() == target) {
            rez.add(new ArrayList<>(tempList)); // Add a copy of tempList to the result
            return; // Return to avoid further unnecessary recursion
        }
        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] <= target) {
                tempList.add(candidates[i]);
                compositionSum(rez, candidates, target, i + 1, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}