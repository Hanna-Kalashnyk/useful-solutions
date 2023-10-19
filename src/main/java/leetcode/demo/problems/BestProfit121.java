package leetcode.demo.problems;

public class BestProfit121
{
	public int maxProfit(int[] prices)
	{
		if (prices.length < 2)
			return 0;
		
		int maxProfit = 0;
		int minInd = 0;
		for (int i = 0; i < prices.length; i++)
		{
			if (prices[i] - prices[minInd] > maxProfit)
				maxProfit = prices[i] - prices[minInd];
			if (prices[i] < prices[minInd])
				minInd = i;
		}
		return maxProfit;
	}
}
