package leetcode.demo.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Given :  members = number of people, invited to two bunkets.
 * relations : member - 1 relations bitween them.
 * queryes : new relations
 *  TODO:   for every relation answer if could we still separate people between two bankets - noone knows another into each
 *          after addtion of new relation from query.
 * <p>
 * if NO >>>> answer int[2] res:
 * res[0] >>> how maany relations should we take out to make it possible
 * res[1] >>> how many varyants are
 */
public class BanketSeparation {
    private static Map<Integer, Set<Integer>> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine().strip();                // Reading input from STDIN
        int tests = Integer.parseInt(name);
        for (int i = 0; i < tests; i++) {
            int members = Integer.parseInt(br.readLine().strip());
            int[][] relations = new int[members - 1][2];
            for (int j = 0; j < members - 1; j++) {
                String[] connection = br.readLine().strip().split(" ");
                relations[j][0] = Integer.parseInt(connection[0]);
                relations[j][1] = Integer.parseInt(connection[1]);
                putInMap(map, relations[j]);
            }
            int q = Integer.parseInt(br.readLine().strip());
            int[][] querys = new int[q][2];
            for (int j = 0; j < q; j++) {
                String[] query = br.readLine().strip().split(" ");
                querys[j][0] = Integer.parseInt(query[0]);
                querys[j][1] = Integer.parseInt(query[1]);
            }
            for (int j = 0; j < q; j++) {
                map = putInMap(map, querys[j]);
                if (couldSeparate(map)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                    int[] vars = bipartialVariants(map, querys[j]);
                    System.out.println(vars[0] + " " + vars[1]);
                }

                map.get(relations[j][0]).remove(relations[j][1]);
                map.get(relations[j][1]).remove(relations[j][0]);
            }
        }
    }

    public static Map<Integer, Set<Integer>> putInMap(Map<Integer, Set<Integer>> map, int[] relat) {
        if (relat != null) {
            Set<Integer> rel1;
            Set<Integer> rel2;

            if (map.containsKey(relat[0]) && !map.get(relat[0]).isEmpty()) {
                rel1 = map.get(relat[0]);
            } else {
                rel1 = new HashSet<>();
            }
            rel1.add(relat[1]);
            map.put(relat[0], rel1);

            if (map.containsKey(relat[1]) && !map.get(relat[1]).isEmpty()) {
                rel2 = map.get(relat[1]);
            } else {
                rel2 = new HashSet<>();
            }
            rel2.add(relat[0]);
            map.put(relat[1], rel2);
        }

        return map;
    }

    public static boolean couldSeparate(Map<Integer, Set<Integer>> map) {

        Set<Integer> part1 = new HashSet<>();
        Set<Integer> part2 = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (Integer node : map.keySet()) {
            part1.add(node);
            queue.add(node);
            while (!queue.isEmpty() && queue.peek() != null) {
                int currentNode = queue.poll();
                if (map.containsKey(currentNode) && !map.get(currentNode).isEmpty()) {
                    for (Integer neighbor : map.get(currentNode)) {
                        if (!part1.contains(neighbor) && !part2.contains(neighbor)) {
                            if (part1.contains(currentNode)) {
                                part2.add(neighbor);
                            } else {
                                part1.add(neighbor);
                            }
                            queue.add(neighbor);
                        } else if ((part2.contains(neighbor) && part2.contains(currentNode)) || (part1.contains(neighbor) && part1.contains(currentNode))) {
                            return false;
                        }

                    }

                }
            }
            break;
        }
        return true;
    }

    public static int[] bipartialVariants(Map<Integer, Set<Integer>> relations, int[] query) {

        int var = 0;
        for (int nodeToExclude : query) {
            if (relations.containsKey(nodeToExclude) && !relations.get(nodeToExclude).isEmpty()) {
                for (int edgeEnd : map.get(nodeToExclude)) {
                    map.get(nodeToExclude).remove(edgeEnd);
                    map.get(edgeEnd).remove(nodeToExclude);

                    if (couldSeparate(map)) var++;

                    map.get(nodeToExclude).add(edgeEnd);
                    map.get(edgeEnd).add(nodeToExclude);
                }
            }
        }
        return new int[]{1, var - 1};
    }
}
