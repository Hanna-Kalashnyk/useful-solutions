//Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
//frequency
// of at least one of the chosen numbers is different.
//
//The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rez = new ArrayList<>();
        Arrays.sort(candidates);
        collectCombinations(rez, candidates, target, new ArrayList<Integer>(), 0);
        return rez;
    }

    private void collectCombinations(List<List<Integer>> rez, int[] nums, int target, ArrayList<Integer> temp, int start) {
        if (target < 0) return;
        else if (target == 0) rez.add(new ArrayList<>(temp));
        else {
            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                collectCombinations(rez, nums, target - nums[i], temp, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
