//Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rez = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        backtracking(set, nums, 0);
        return new ArrayList<>(set);
    }

    private void backtracking(Set<List<Integer>> set, int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            set.add(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            swap(nums, index, i);
            backtracking(set, nums, index+1);
            swap(nums, index, i);
        }
    }
    private void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
   }
}
