package leetcode.demo.problems;

class GoodWords
{
    public int countCharacters(String[] words, String chars)
    {

        int sum = 0;
        for ( String word :
            words )
        {
            sum += isGood(word, chars);
        }
        if ( words.length <= 1000 && words.length >= 1 )
        {
            return sum;
        }
        else
            return 0;

    }

    private int isGood(String word, String chars)
    {
        int res = 0;
        char[] wordArray = word.toCharArray();
        char[] charsArray = chars.toCharArray();

        for ( char c : wordArray )
        {
            for ( int i = 0; i < charsArray.length; i++ )
                if ( charsArray[i] == c )
                {
                    charsArray[i] = '*';
                    res++;
                    break;
                }
        }
        if ( word.length() == res && chars.length() <= 100 && word.length() >= 1 )
            return res;
        else
            return 0;
    }
}