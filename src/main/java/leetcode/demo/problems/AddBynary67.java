//Given two binary strings a and b, return their sum as a binary string.
package leetcode.demo.problems;

public class AddBynary67
{
	public String addBinary(String a, String b)
	{
		StringBuilder asb = new StringBuilder(a);
		asb.reverse();
		StringBuilder bsb = new StringBuilder(b);
		bsb.reverse();
		StringBuilder tail = new StringBuilder();
		
		int asize = asb.length();
		int bsize = bsb.length();
		if (asize != bsize)
		{
			for (int i = 0; i < Math.abs(asize - bsize); i++)
			{
				tail.append(0);
			}
			
		}
		if (asb.length() > bsb.length())
			bsb.append(tail);
		else
			asb.append(tail);
		
		char[] ach = asb.toString().toCharArray();
		char[] bch = bsb.toString().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		int reserve = 0;
		for (int i = 0; i < asize; i++)
		{
			if (ach[i] == bch[i])
			{
				if (ach[i] == 1)
				{
					sb.append(reserve);
					reserve = 1;
				}
				else
				{
					sb.append(reserve);
					reserve = 0;
				}
			}
			else
			{
				if (reserve == 1)
				{
					sb.append(0);
				}
				else
				{
					sb.append(1);
					
				}
			}
		}
		sb.append(reserve);
		return sb.reverse().toString();
	}


	public String addBinary2(String a, String b) {
		StringBuilder res = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while ( i >=0 || j >= 0 || carry != 0){
			int achar = i >= 0 ? a.charAt(i) - '0' : 0;
			int bchar = j >= 0 ? b.charAt(j) - '0' : 0;
			int sum = achar + bchar + carry;

			res.insert(0, sum%2);
			carry = sum / 2;
			i--;
			j--;
		}
		return res.toString();
	}
}