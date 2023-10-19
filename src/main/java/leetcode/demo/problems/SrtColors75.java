//Given an array nums with n objects colored red, white, or blue, sort them in-place
// so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//You must solve this problem without using the library's sort function.
package leetcode.demo.problems;

import java.util.HashMap;
import java.util.Map;

public class SrtColors75 {
    public void sortColors(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = count; i < count + entry.getValue(); i++) {
                nums[i] = entry.getKey();
            }
            count = count + entry.getValue();
        }
    }
}
