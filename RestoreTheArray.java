//A program was supposed to print an array of integers.
//    The program forgot to print whitespaces and the array is printed
//    as a string of digits s and all we know is that all integers in the array
//    were in the range [1, k] and there are no leading zeros in the array.
//
//    Given the string s and the integer k, return the number of the possible arrays
//    that can be printed as s using the mentioned program. Since the answer may be very large,
//    return it modulo 109 + 7.
//    package leetcode;

public class RestoreTheArray
{
    public int numberOfArrays(String s, int k)
    {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s, k, 0, dp);
    }

    public int dfs(String s, int k, int i, int[] dp)
    {

        if ( i == s.length() )
            return 1;
        if ( s.charAt(i) == '0' )
            return 0;
        if ( dp[i] != -1 )
            return dp[i];

        int ans = 0;
        long num = 0;
        for ( int j = i; j < s.length(); j++ )
        {
            num = num * 10 + s.charAt(j) - '0';
            if ( num > k )
                break;
            ans = (ans + dfs(s, k, j + 1, dp)) % 1000000007;
        }
        return dp[i] = ans;
    }


    public int numberOfArrays1(String s, int k)   {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                continue;
            }
            for (int j = i; j < s.length(); j++) {
                String num = s.substring(i, j + 1);
                if (Long.parseLong(num) > k) {
                    break;
                }
                dp[j + 1] = (dp[j + 1] + dp[i]) % 1000000007;
            }
        }
        return dp[s.length()];
    }
}
}