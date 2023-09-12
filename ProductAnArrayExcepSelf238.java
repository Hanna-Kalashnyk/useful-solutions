
//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.
package leetcode;

public class ProductAnArrayExcepSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int curr = 1;
        int n = nums.length;
        int[] rez = new int[n];
        for (int i = 0; i < n; i++) {
            rez[i] = curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            rez[i] *= curr;
            curr *= nums[i];
        }
        return rez;
    }
}
