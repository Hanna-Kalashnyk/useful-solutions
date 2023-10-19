//Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
// typically using all the original letters exactly once.
package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinString432 {
    public List<Integer> findAnagramsNotEffective(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        char[] array = s.toCharArray();
        int n = p.length();
        for (int i = 0; i < s.length() - n + 1; i++) {
            if (map.containsKey(array[i])) {
                int anagramCurrLength = n;
                Map<Character, Integer> currMap = new HashMap<>(map);
                int j = i;
                while (anagramCurrLength > 0) {
                    if (currMap.containsKey(array[j]) && (currMap.get(array[j]) > 0)) {
                        currMap.put(array[j], currMap.get(array[j]) - 1);
                        anagramCurrLength--;
                        j++;
                        if (anagramCurrLength == 0) {
                            res.add(i);

                        }
                    } else break;
                }
            }
        }
        return res;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] anagrFrequency = new int[26];
        for (char ch : p.toCharArray()) {
            anagrFrequency[ch - 'a']++;
        }
        int n = p.length();
        int left = 0, right = 0;
        int matchCounter = n;
        while (right < s.length()) {
            if (anagrFrequency[s.charAt(right) - 'a']-- > 0) {
                matchCounter--;
            }
            right++;
            if (right - left == n) {
                if (matchCounter == 0) res.add(left);
                if (anagrFrequency[s.charAt(left) - 'a']++ >= 0) matchCounter++;
                left++;
            }
        }
        return res;
    }

    public List<Integer> findAnagramsSergii(String s, String p) {

        List<Integer> res = new ArrayList<>();
        int[] anagrFrequency = new int[26];
        int n = p.length();
        int matchCounter = n;

        for (char ch : p.toCharArray()) {
            anagrFrequency[ch - 'a']++;
        }

        for (int right = 0; right < s.length(); right++) {
            if (anagrFrequency[s.charAt(right) - 'a']-- > 0) {
                matchCounter--;
            }
            if (right >= n - 1) {
                int left = right - n + 1;
                if (matchCounter == 0) {
                    res.add(left);
                }
                if (anagrFrequency[s.charAt(left) - 'a']++ >= 0) {
                    matchCounter++;
                }
            }
        }
        return res;
    }
}