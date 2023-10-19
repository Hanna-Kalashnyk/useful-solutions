package leetcode.demo.problems;//Given an array of integers nums, calculate the pivot index of this array.
//
//    The pivot index is the index where the sum of all the numbers strictly to the left
//    of the index is equal to the sum of all the numbers strictly to the index's right.
//
//    If the index is on the left edge of the array, then the left sum is 0 because
//    there are no elements to the left. This also applies to the right edge of the array.
//
//    Return the leftmost pivot index. If no such index exists, return -1.package leetcode;


public class PivotIndex
{
    public int pivotIndex(int[] nums)
    {
        if ( nums.length > 10000 || nums.length < 1 )
        {
            System.out.println("out of constrains");
        }
        int totalSum = 0;
        int sum = 0;
        int leftSum = 0;
        int rightSum = 0;
        for ( int el : nums )
        {
            totalSum += el;
        }
        for ( int i = 0; i < nums.length; i++ )
        {
            if ( nums[i] < -1000 || nums[i] > 1000 )
            {
                System.out.println("out of constrains");
            }

            sum += nums[i];
            leftSum = sum - nums[i];
            rightSum = totalSum - sum;
            if ( leftSum == rightSum )
                return i;
        }
        return -1;
    }
}
