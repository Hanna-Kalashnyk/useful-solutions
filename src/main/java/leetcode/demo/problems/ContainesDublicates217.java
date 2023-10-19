//Given an integer array nums, return true if any value appears at least twice in the array,
// and return false if every element is distinct.
package leetcode.demo.problems;

import java.util.HashSet;
import java.util.Set;

public class ContainesDublicates217 {
    public boolean containsDuplicate(int[] nums) {
        Set set = new HashSet<>();
        for (int num:nums) {
            set.add(num);
        }
return nums.length != set.size();
    }
}