//Given an array nums of n integers where nums[i] is in the range [1, n],
// return an array of all the integers in the range [1, n] that do not appear in nums.
package leetcode.demo.problems;

import java.util.*;

public class DisappearedNumbersInArray448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Set<Integer> missed = new HashSet<>();
        int i = 1;
        while (i <= nums.length) {
            missed.add(i);
            i++;
        }
        for (int num : nums) {
            if (missed.contains(num)) {
                missed.remove(num);
            }
        }
        return new ArrayList<>(missed);
    }
}
