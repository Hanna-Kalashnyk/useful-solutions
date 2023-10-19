//Given an integer array nums sorted in non-decreasing order,
// return an array of the squares of each number sorted in non-decreasing order.
package leetcode.demo.problems;


public class SquaresofSortedArray977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] rez = new int[n];
        int left = 0, right = n - 1;

        n = n - 1;
        while (left <= right) {
            if (nums[left] * nums[left] <= nums[right] * nums[right]) {
                rez[n] = nums[right] * nums[right];
                right--;
            } else {
                rez[n] = nums[left] * nums[left];
                left++;
            }
            n--;
        }
        return rez;
    }
}
