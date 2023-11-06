package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 * <p>
 * Return a list of all possible strings we could create. Return the output in any order.
 */
public class LetterCasePermutation784 {
    public List<String> letterCasePermutation(String s) {
        List<String> rez = new ArrayList<>();
        backTracking(rez, s.toCharArray(), 0, new StringBuilder(), s.length());
        return rez;
    }

    private void backTracking(List<String> rez, char[] chars, int i, StringBuilder temp, int n) {
        if (temp.length() == n) {
            rez.add(temp.toString());
            return;
        }
        if (Character.isLetter(chars[i])) {
            temp.append(Character.toUpperCase(chars[i]));
            backTracking(rez, chars, i + 1, temp, n);
            temp.deleteCharAt(temp.length() - 1);
            temp.append(Character.toLowerCase(chars[i]));
            backTracking(rez, chars, i + 1, temp, n);
            temp.deleteCharAt(temp.length() - 1);
        } else {
            temp.append(chars[i]);
            backTracking(rez, chars, i + 1, temp, n);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
