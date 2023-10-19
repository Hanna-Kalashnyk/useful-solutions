//Given an integer array nums that may contain duplicates, return all possible
//subsets
// (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.
package leetcode.demo.problems;

import java.util.*;

public class SubsetII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> rez = new HashSet<>();
        Arrays.sort(nums);
        backtrack(nums, rez, 0, new ArrayList<Integer>());
        return  new ArrayList<>(rez);
    }
    private void backtrack(int[] nums, Set<List<Integer>> rez, int index, List temp){
        rez.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, rez, i+1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
