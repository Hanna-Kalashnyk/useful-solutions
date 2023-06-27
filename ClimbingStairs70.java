//ou are climbing a staircase. It takes n steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
package leetcode;

public class ClimbingStairs70
{
	public int climbStairsFib(int n)
	{
		{
			if (n < 4)
				return n;
			int[] res = new int[n];
			res[0] = 1;
			res[1] = 2;
			
			for (int i = 2; i < n; i++)
			{
				res[i] = res[i-1] + res[i-2];
			}
			return res[n - 1];
		}
	}
	
	
	public int climbStairsDynam(int n) {
		if(n < 4)
			return n;
		int f = 2, s = 3, t = 0;
		for(int i = 3; i < n; i++){
			t = f + s;
			f = s;
			s = t;
		}
		return t;
	}
}