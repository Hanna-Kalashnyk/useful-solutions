package leetcode;

public class RemoveDuplicatesfromSortedArray267
{
    public int removeDuplicates(int[] nums)
    {
        if (nums.length < 2)
            return nums.length;
        int k = 0, i = 0;
        while ( i  < nums.length )
        {
            while ( i+1 < nums.length && nums[i] == nums[i + 1] )
            {
                i++;
            }
            nums[k] = nums[i];
            k++;
            i++;
        }
        for ( int j = k + 1; j < nums.length; j++ )
        {
            nums[j] = 0;
        }
        return k;
    }

}
