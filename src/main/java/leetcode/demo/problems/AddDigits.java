package leetcode.demo.problems;

public class AddDigits
{
    public int addDigits(int num)
    {
        if ( num / 10 != 0 )
        {
            num = addDigits(sumNumbers(num));
        }
        return num;
    }

    private int sumNumbers(int n)
    {
        int d;
        int sum = 0;
        while ( n > 0 )
        {
            d = n % 10;
            sum += d;
            n /= 10;
        }
        return sum;
    }
}