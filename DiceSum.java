class DiceSum
{
    public static void main(String[] args)
    {
        System.out.println(numRollsToTarget(2, 3, 1 ));
    }
    public int numRollsToTarget(int n, int k, int target)
    {

        int MOD = 1000000007;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for ( int i = 1; i <= n; i++ )
        {
            for ( int j = 1; j <= target; j++ )
            {
                for ( int l = 1; l <= k && l <= j; l++ )
                {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % MOD;
                }
            }
        }

        return dp[n][target];
    }
}

//In this solution, we use dynamic programming to calculate the number of possible ways to roll
// the dice to get a sum of target.
//    We use a 2D array dp to store the number of ways to roll i dice to get a sum of j.
//
//    To fill in the dp array, we use a nested loop that iterates over the number of dice i,
//    the target sum j,
//    and the possible face-up numbers of each die l. We calculate the number of ways to roll
//    i-1 dice to get a sum of j-l,
//    and add this to the number of ways to roll i dice to get a sum of j. We take the result
//    modulo 10^9+7 to ensure
//    that the answer doesn't overflow.
//
//    Finally, we return dp[n][target], which represents the number of possible ways to roll n
//    dice to get a sum of target.