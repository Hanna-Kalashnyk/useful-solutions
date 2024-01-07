package leetcode.demo.problems;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class BiPartitioningOfConnectedGraph {
        private static int[][] relations;

        public static void main(String args[]) throws Exception {
            //BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String name = br.readLine().strip();                // Reading input from STDIN
            int tests = Integer.parseInt(name);
            // StringBuilder out = new StringBuilder();
            for (int i = 0; i < tests; i++) {
                int members = Integer.parseInt(br.readLine().strip());
                int[][] relations = new int[1000000][1000000];
                for (int j = 0; j < members - 1; j++) {
                    String[] connection = br.readLine().strip().split(" ");
                    int row = Integer.parseInt(connection[0]);
                    int col = Integer.parseInt(connection[1]);
                    relations[row][col] = 1;
                    relations[col][row] = 1;
                }
                int q = Integer.parseInt(br.readLine().strip());
                int[][] querys = new int[q][2];
                for (int j = 0; j < q; j++) {
                    String[] query = br.readLine().strip().split(" ");
                    querys[j][0] = Integer.parseInt(query[0]);
                    querys[j][1] = Integer.parseInt(query[1]);
                }
                for (int j = 0; j < q; j++) {
                    relations[querys[j][0]][querys[j][1]] = 1;
                    relations[querys[j][1]][querys[j][2]] = 1;
                    if (isBipatite(relations)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                        int vars[] = bipartialVariants(relations, querys[j]);
                        System.out.println(vars[0] + " " + vars[1]);
                    }
                    relations[querys[j][0]][querys[j][1]] = 0;
                    relations[querys[j][1]][querys[j][2]] = 0;
                }
                // System.out.println(out.toString());
            }
        }

        public static boolean isBipatite(int[][] relations) {
            Queue<Integer> queue = new LinkedList<>();
            int n = 1000000;
            int[] vertices = new int[n];
            Arrays.fill(vertices, -1);
            for (int i = 0; i < n; i++) {
                if (relations[i][i] == 1) return false;
                if (vertices[i] == -1) {
                    vertices[i] = 1;
                    queue.offer(vertices[i]);
                }
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (int u = 0; u < n; u++) {
                        if (relations[u][v] == 1 && vertices[u] == -1) {
                            if (relations[u][u] == 1) return false;

                            vertices[u] = 1 - vertices[v];
                            queue.offer(vertices[u]);
                        } else {
                            if (vertices[u] == vertices[v]) return false;
                        }
                    }
                }
            }
            return true;
        }

        public static int[] bipartialVariants(int[][] relations, int[] query) {
            int var = 0;

            var = backTracking(relations, query, var);

            return new int[]{1, var};
        }

        public static int backTracking(int[][] relations, int[] query, int var) {

            for (int i = 0; i < query.length; i++) {
                for (int v = 0; v < relations.length; v++) {
                    if (relations[query[i]][v] == 1) {
                        relations[query[i]][v] = 0;
                        relations[v][query[i]] = 0;

                        if (isBipatite(relations)) var++;;

                        relations[query[i]][v] = 1;
                        relations[v][query[i]] = 1;
                    }
                }
            }
            return var;
        }
    }
