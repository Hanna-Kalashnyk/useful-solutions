//You are given an integer array coins representing coins of different
// denominations and an integer amount representing a total amount of money.
//
//Return the fewest number of coins that you need to make up that amount.
// If that amount of money cannot be made up by any combination of the coins, return -1.
//
//You may assume that you have an infinite number of each kind of coin.
package leetcode;

public class CoinChange322
{
	public int coinChange(int[] coins, int amount)
	{
		int[] dp = new int[amount + 1];
		
		for (int i = 1; i <= amount; i++)
		{
			dp[i] = Integer.MAX_VALUE;
			for (int coin : coins)
				if (i >= coin && dp[i - coin] != Integer.MAX_VALUE)
					dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
		}
		
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}
}