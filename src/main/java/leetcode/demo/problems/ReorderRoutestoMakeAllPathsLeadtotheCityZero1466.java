package leetcode.demo.problems;

import java.util.*;

/**
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
 * <p>
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 * <p>
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 * <p>
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 * <p>
 * It's guaranteed that each city can reach city 0 after reorder.
 */
public class ReorderRoutestoMakeAllPathsLeadtotheCityZero1466 {
    int count = 0;

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int[] con : connections) {
            map.computeIfAbsent(con[0], k -> new ArrayList<List<Integer>>()).add(new ArrayList<Integer>(Arrays.asList(con[1], 1)));
            map.computeIfAbsent(con[1], k -> new ArrayList<List<Integer>>()).add(new ArrayList<Integer>(Arrays.asList(con[0], 0)));
        }
        bsf(map, 0, n);
        return count;
    }

    public void bsf(Map<Integer, List<List<Integer>>> map, int node, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (!map.containsKey(curr)) continue;

            for (List<Integer> neibor : map.get(curr)) {
                int neibNode = neibor.get(0);
                int reverse = neibor.get(1);
                if (!visited[neibNode]) {
                    visited[neibNode] = true;
                    count += reverse;
                    queue.offer(neibNode);

                }
            }
        }
    }


    public int minReorderSuperFast(int n, int[][] connections) {
        int count = 0;
        Stack<Integer> st1 = new Stack<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        for (int i = 0; i < connections.length; i++) {
            if (visited[connections[i][0]]) {
                count++;
                visited[connections[i][1]] = true;
            } else if (visited[connections[i][1]]) {
                visited[connections[i][0]] = true;
            } else {
                st1.push(i);
            }
        }

        Stack<Integer> st2 = new Stack<>();
        while (!st1.isEmpty()) {
            int i = st1.pop();
            if (visited[connections[i][0]]) {
                count++;
                visited[connections[i][1]] = true;
            } else if (visited[connections[i][1]]) {
                visited[connections[i][0]] = true;
            } else {
                st2.push(i);
            }
        }

        while (!st2.isEmpty()) {
            int i = st2.pop();
            if (visited[connections[i][0]]) {
                count++;
                visited[connections[i][1]] = true;
            } else if (visited[connections[i][1]]) {
                visited[connections[i][0]] = true;
            } else {
                st1.push(i);
            }
        }

        return count;
    }
}
