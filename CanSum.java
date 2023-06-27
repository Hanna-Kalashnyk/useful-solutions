package AmazonInterview;
import java.util.HashMap;


class CanSum
{
    public static void main(String[] args)
    {
        CanSum canSum = new CanSum();
        System.out.println(canSum.CanSumFromArray(new int[] { 3, 4 }, 4));

    }

    public int CanSumFromArray(int[] nums, int target)
    {
        HashMap<Integer, Integer> memo = new HashMap<>();

        int rez = 0;
        if ( target == 0 )
            return 1;
        if ( target < 0 )
            return -1;
        for ( Integer num : nums )
        {

            if ( memo.containsKey(target - num) )
            {
                if ( target == num )
                {
                    memo.put(target - num, memo.get(target - num) + 1);
                    rez++;
                }
            }

            else
            {
                memo.put(target - num, CanSumFromArray(nums, target - num));
            }

        } return rez;
    }
}