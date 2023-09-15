//Given an array nums of distinct integers, return all the possible permutations.
// You can return the answer in any order.
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation46 {
    public List<List <Integer>> permutations(int[] nums){
        List<List<Integer>> rez = new ArrayList<>();
        backTracking(nums, rez, 0);
        return rez;
    }
    private void backTracking (int[] nums, List<List<Integer>> rez, int start){
        if (start == nums.length){
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                curr.add(nums[i]);
            }
            rez.add(curr);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(start, i, nums);
            backTracking(nums, rez, start +1);
            swap(start, i, nums);
        }
    }

    private void swap(int start, int end, int[] nums){
        int temp =nums[start];
        nums[start] = nums[end];
        nums[end] = nums[temp];
    }
}
