import java.util.HashMap;

class SumTwoSortedArray
{
    public int[] twoSum(int[] numbers, int target)  {
        int[] res = new int[2];
        if ( 2 > numbers.length || numbers.length > 30000 || -1000 > target || target > 1000 )
            return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < numbers.length; i++ )
        {
            if ( -1000 > numbers[i] || numbers[i] > 1000 )
                return res;
            if ( map.containsKey(numbers[i]) )
            {
                res[0] = map.get(numbers[i]) + 1;
                res[1] = i + 1;
                return res;
            }
            else
            {
                map.put(target - numbers[i], i);
            }
        }
        return res;
    }
}