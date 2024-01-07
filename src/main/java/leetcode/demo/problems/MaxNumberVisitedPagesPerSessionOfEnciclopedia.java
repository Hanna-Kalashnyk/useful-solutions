package leetcode.demo.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * You're having a grand old time clicking through the rabbit hole that is your favorite online encyclopedia.
 * The encyclopedia consists of N different web pages, numbered from 1 to N. There are M links present across the pages,
 * the ith of which is present on pageAi and links to a different page Bi
 * . A page may include multiple links, including multiple leading to the same other page.
 * A session spent on this website involves beginning on one of the N pages, and then navigating around
 * using the links until you decide to stop. That is, while on page i,
 * you may either move to any of the pages linked to from it, or stop your browsing session.
 * Assuming you can choose which page you begin the session on, what's the maximum number of different pages
 * you can visit in a single session? Note that a page only counts once even if visited multiple times during the session.
 */
public class MaxNumberVisitedPagesPerSessionOfEnciclopedia {
    public int getMaxVisitableWebpages(int N, int M, int[] A, int[] B) {

        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < M; i++) {
            map.putIfAbsent(A[i], new HashSet<Integer>());
            map.get(A[i]).add(B[i]);
        }
        int res = 1;
        int curr = 1;
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            res = Math.max(res, dfs(map, curr, entry.getKey(), new boolean[N]));
        }
        return res;
    }

    public static int dfs(Map<Integer, HashSet<Integer>> map, int curr, Integer node, boolean[] visited) {
        if (map.containsKey(node)) {
            for (Integer child : map.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    curr = Math.max(curr, dfs(map, curr + 1, child, visited));
                    visited[child] = false;
                }
            }
        }
        return curr;
    }

}
