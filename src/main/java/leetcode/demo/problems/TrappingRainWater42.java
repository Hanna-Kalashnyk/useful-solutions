//Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it can trap after raining.
package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TrappingRainWater42 {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        right[height.length - 1] = 0;
        left[0] = 0;

        int leftBarrier = 0;
        int rightBarrier = 0;
        int rez = 0;
        int min;
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(rightBarrier, height[i + 1]);
            rightBarrier = right[i];

        }
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(leftBarrier, height[i - 1]);
            leftBarrier = left[i];

            min = Math.min(left[i], right[i]);

            if (height[i] < min)
                rez += min - height[i];
        }
        return rez;
    }
}

