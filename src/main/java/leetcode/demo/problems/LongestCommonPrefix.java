package leetcode.demo.problems;

public class LongestCommonPrefix

{
    public String longestCommonPrefix(String[] strs)
    {

        String prefixstr = strs[0];
        char[] prefix = strs[0].toCharArray();
        for ( String str : strs )
        {

            char[] chrs = str.toCharArray();
            if ( str == "" || str.isEmpty() || chrs[0] != prefix[0] )
                return "";

            for ( int i = 1; i < Math.min(prefixstr.length(), chrs.length); i++ )
            {
                if ( chrs[i] != prefix[i] )
                {
                    prefixstr = prefixstr.substring(0, i );
                    break;
                }
                prefixstr =  prefixstr.substring(0, Math.min(prefixstr.length(), chrs.length));
            }
        }
        return prefixstr;
    }
}