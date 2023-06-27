//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.
//
//
package leetcode;

import java.util.*;

public class ThreeSum15
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<List<Integer>> rez = new ArrayList<>();
        for ( int i = 0; i < nums.length; i++ )
        {
            int[] numsWithouti = new int[nums.length - 1];
            int l = 0;
            for ( int y = 0; y < nums.length; y++ )
            {
                if ( y == i )
                    continue;
                numsWithouti[l] = nums[y];
                l++;
            }
            int target = -1 * nums[i];
            rez.addAll(rez.size(), twoSum(numsWithouti, target));
            set.addAll(rez);

        }
        List<List<Integer>> rezf = new ArrayList<>();
        for ( List<Integer> list : set )
        {
            rezf.add(list);
        }
        return rezf;
    }

    public List<List<Integer>> twoSum(int[] numsWithouti, int target)
    {
        List<List<Integer>> rez = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < numsWithouti.length; i++ )
        {
            if ( map.containsKey(numsWithouti[i]) )
            {
                List<Integer> list = new ArrayList<>();
                list.add(numsWithouti[i]);
                list.add(numsWithouti[map.get(numsWithouti[i])]);
                int minusTarget = (-1) * target;
                list.add(minusTarget);
                list.sort((a, b) -> (a - b));
                rez.add(list);
            }
            map.put(target - numsWithouti[i], i);
        }
        return rez;
    }
}