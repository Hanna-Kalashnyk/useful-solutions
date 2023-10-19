package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TrainClass {
    public List<List<Integer>> targetSubsets(int[] nums, int target){
        Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    backtrack(nums, res, target, 0, new ArrayList<Integer>());
    return res.stream().distinct().collect(Collectors.toList());
    }

    private void backtrack(int[] nums, List<List<Integer>> res, int target, int start, List<Integer> temp){
        if (target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, res, target - nums[i], i +1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static ListNode middle(ListNode root){
        ListNode nodeSlow = root;
        ListNode nodeFast = root;

        while(nodeFast != null && nodeFast.next != null) {
            nodeFast = nodeFast.next.next;
            nodeSlow = nodeSlow.next;
        }
return nodeSlow;
    }
}
