//You are given an integer array coins representing coins
// of different denominations and an integer amount representing a total amount of money.
//
//Return the number of combinations that make up that amount.
// If that amount of money cannot be made up by any combination of the coins, return 0.
package leetcode.demo.problems;

public class CoinChangeII518
{
	public int change(int amount, int[] coins)
	{
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins)
		{
			for (int i = 0; i < amount + 1 ; i++)
			{
				if ( i >= coin)
				dp[i] = dp[i] + dp[i - coin];
			}
		}
		return dp[amount];
	}
	
}