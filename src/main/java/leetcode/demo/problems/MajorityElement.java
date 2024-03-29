package leetcode.demo.problems;

import java.util.HashMap;

class MajorityElement
{
    public int majorityElement(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for ( int i = 0; i < n; i++ )
        {
            if ( !map.containsKey(nums[i]) )
            {

                map.put(nums[i], 1);
            }
            else
            {
                map.replace(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > n/2) return nums[i];
            }
        }return n;
    }
}