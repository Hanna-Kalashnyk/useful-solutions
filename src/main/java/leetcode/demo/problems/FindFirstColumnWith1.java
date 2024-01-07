package leetcode.demo.problems;

// return the first index of column with 1 in it from the int[][] nums, where just 0 and 1 inside and all rows are sorted in undecreasing order;
public class FindFirstColumnWith1 {
    public int leftMostColumnWithOne(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int min = Integer.MIN_VALUE;
        int currMin = 0;
        for (int i = 0; i < n; i++) {
            if (1 == nums[i][m - 1]) {
                int right = m;
                int left = 0;
                while (left < right) {
                    int md = (left + right) / 2;
                    if (nums[i][md] == 1) {
                        right = md;
                    } else {
                        left = md;
                    }
                }
                currMin = right;

            }
            min = Math.min(min, currMin);

        }
        return min == Integer.MIN_VALUE ? -1 : min;
    }
}

