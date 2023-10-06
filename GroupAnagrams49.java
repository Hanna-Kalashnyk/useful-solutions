//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
// typically using all the original letters exactly once.
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            char[] chars26 = new char[26];
            for (char ch : chars) {
                chars26[ch - 'a']++;
            }
            String key = String.valueOf(chars26);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
