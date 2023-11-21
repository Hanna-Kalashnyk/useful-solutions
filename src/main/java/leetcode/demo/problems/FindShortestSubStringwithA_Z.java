package leetcode.demo.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindShortestSubStringwithA_Z {
    public static int findShortestABC(String str) {
        int res = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <= str.length(); i++) {
            char c = str.charAt(i);
            if ( c == 'A') {
                map.put('A', i);
            } else {
                if (str.charAt(i) == 'Z') {
                    return Math.min(res, i - map.get(c) + 1);
                }
                if (map.containsKey((char)(c - 1))){
                    int start = map.get((char) (c - 1));
                    map.put(c, start);
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String example = "ABCDEFDAKABCFGHIJGDEFKLMNOGPQRSTUVWXYZZZAZFBSCDEFGHIJGKLMNOPQRSTUVWXYZ";
        System.out.println(getShortest(example));

    }

    public static String getShortest(String str) {
        int [] startAIndex = new int[26];
        Arrays.fill(startAIndex, -1);
        int start = Integer.MIN_VALUE;
        int end = Integer.MAX_VALUE;
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i) - 'A';
            if (value == 0) {
                startAIndex[0] = i;
            } else if (startAIndex[value - 1] != -1) {
                startAIndex[value] = startAIndex[value - 1];
                if (value == 25 && i - startAIndex[value] < distance) {
                    distance = i - startAIndex[value];
                    start = startAIndex[value];
                    end = i;
                }
            }
        }
        return str.substring(start, end + 1);
    }
}
