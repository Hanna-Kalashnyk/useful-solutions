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
public class BanketSeparation_TwoColorArrayApproach {
    public static void main(String args[]) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine().strip();                // Reading input from STDIN
        int tests = Integer.parseInt(name);
        // StringBuilder out = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            int members = Integer.parseInt(br.readLine().strip());
            List<Node[]> relations = new ArrayList<>();
            for (int j = 0; j < members - 1; j++) {
                String[] connection = br.readLine().strip().split(" ");
                int row = Integer.parseInt(connection[0]);
                int col = Integer.parseInt(connection[1]);
                Node node1 = new Node(row);
                Node node2 = new Node(col);
                Node[] rel = {node1, node2};
                relations.add(rel);
            }
            int q = Integer.parseInt(br.readLine().strip());
            Node[][] querys = new Node[q][2];
            for (int j = 0; j < q; j++) {
                String[] query = br.readLine().strip().split(" ");
                querys[j][0] = new Node(Integer.parseInt(query[0]));
                querys[j][1] = new Node(Integer.parseInt(query[1]));
            }
            for (int j = 0; j < q; j++) {
                relations.add(querys[j]);
                if (isBipartite(relations)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                    int vars[] = bipartialVariants(relations, querys[j]);
                    System.out.println(vars[0] + " " + vars[1]);
                }
                relations.remove(querys[j]);
            }
            // System.out.println(out.toString());
        }
    }

    static class Node {
        int val;
        int color;

        Node(int val) {
            this.val = val;
            this.color = -1;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        private static boolean equals(Node node1, Node node2) {
            return node1.val == node2.val;
        }
    }

    public static boolean isBipartite(List<Node[]> relations) {
        for (Node[] pair : relations) {
            pair[0].setColor(-1);
            pair[1].setColor(-1);
        }
        Queue<Node> queue = new LinkedList<>();
        Node node = relations.get(0)[0];
        if (node.equals(relations.get(0)[1])) return false;
        if (node.getColor() == -1) {
            node.setColor(1);
            queue.offer(node);
        }
        while (!queue.isEmpty()) {
            Node v = queue.poll();
            Node u = null;

            Iterator<Node[]> iterator = relations.iterator();

            while (iterator.hasNext()) {
                Node[] rel = iterator.next();

                if (rel[0].equals(v)) u = rel[1];
                if (rel[1].equals(v)) u = rel[0];

                if (u.getColor() == -1) {
                    u.setColor(1 - v.getColor());
                    queue.offer(u);
                } else if (v.getColor() == u.getColor()) return false;
            }
        }
        return true;
    }

    public static int[] bipartialVariants(List<Node[]> relations, Node[] query) {
        int var = 0;
        Iterator<Node[]> iterator = relations.iterator();

        while (iterator.hasNext()) {
            Node[] rel = iterator.next();

            if (rel[0].equals(query[0]) || rel[1].equals(query[0]) || rel[0].equals(query[1]) || rel[1].equals(query[1])) {
                iterator.remove();
                if (isBipartite(relations)) {
                    var++;
                }
                relations.add(rel);
            }
        }
        return new int[]{1, var};
    }
}

