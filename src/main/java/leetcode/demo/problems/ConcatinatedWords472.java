package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
 * <p>
 * A concatenated word is defined as a string that is comprised entirely of
 * at least two shorter words (not necessarily distinct) in the given array.
 */
public class ConcatinatedWords472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (set.contains(words[i].substring(0, j)) && words[i].length() > j) {
                    if (detect(words[i].substring(j), set)) {
                        res.add(words[i]);
                    }
                }
            }
        }
        return new ArrayList<String>(res);
    }


    boolean detect(String word, Set<String> set) {

        for (int j = 0; j <= word.length(); j++) {
            if (set.contains(word.substring(0, j))) {
                if (j == word.length()) {
                    return true;
                } else {
                    if (detect(word.substring(j), set)) return true;
                }
            }

        }
        return false;
    }
    // Trie + Memoization
// Beats 94%

    public List<String> findAllConcatenatedWordsInADictTrie(String[] words) {
        ArrayList<String> list = new ArrayList<String>();
        Trie trie = new Trie();
        for (String x : words) {
            insert(x, trie);
        }
        for (String x : words) {
            if (solve(x, trie, 0, 1, new Boolean[x.length()], 0))
                list.add(x);
        }
        return list;
    }


    private boolean solve(String s, Trie trie, int i, int j, Boolean[] memo, int c) {
        if (i == s.length()) {
            return c > 1; // more than 1 string
        }
        if (memo[i] != null) {
            return memo[i];
        }
        Trie dict = trie;
        for (int k = i; k < s.length(); k++) {
            dict = dict.a[s.charAt(k) - 'a'];
            if (dict == null) {
                return memo[i] = false;
            }
            if (dict.stop) {
                if (solve(s, trie, k + 1, k + 2, memo, c + 1))
                    return true;
            }
        }
        return memo[i] = false;
    }

    private void insert(String s, Trie trie) {
        for (char ch : s.toCharArray()) {
            if (trie.a[ch - 'a'] == null) {
                trie.a[ch - 'a'] = new Trie();
            }
            trie = trie.a[ch - 'a'];
        }
        trie.stop = true;
    }
}

class Trie {
    Trie[] a;
    boolean stop;

    public Trie() {
        a = new Trie[26];
        stop = false;
    }
}

