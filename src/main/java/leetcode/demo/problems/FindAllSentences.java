package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllSentences {
    public List<String> findSentences(String str, String[] dictionary) {
        List<String> res = new ArrayList<>();
        if (dictionary.length == 0) return res;
        Map<Character, List<String>> map = new HashMap<>();
        for (String word : dictionary) {
            List<String> list = map.getOrDefault(word.charAt(0), new ArrayList<>());
            list.add(word);
            map.put(word.charAt(0), list);
        }
        StringBuilder sb = new StringBuilder();

        findSent(res, sb, 0, map, str);
        return res;
    }
    public void findSent(List<String> res, StringBuilder sb, int  i,  Map<Character, List<String>> map, String str) {
        if (i == str.length()) {
            sb.setCharAt(sb.length() - 1, '.');
            res.add(new String(sb.toString()));

            return;
        }
        if (i < str.length() && map.containsKey(str.charAt(i))) {
           for (String word : map.get(str.charAt(i))) {
               sb.append(word + " ");
               findSent(res, sb, i + word.length(), map, str);
               sb.delete(sb.length() - word.length() - 1, sb.length());
           }
        }
    }
}
