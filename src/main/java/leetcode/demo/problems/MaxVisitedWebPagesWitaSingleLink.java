package leetcode.demo.problems;

/**
 * You're having a grand old time clicking through the rabbit hole that is your favorite online encyclopedia.
 * The encyclopedia consists of N different web pages, numbered from 1 to N. Each page i contains nothing
 * but a single link to a different page L[i]
 * A session spent on this website involves beginning on one of the N pages,
 * and then navigating around using the links until you decide to stop. That is, while on page i, you may either move to page
 , or stop your browsing session.
 * Assuming you can choose which page you begin the session on, what's the maximum number
 * of different pages you can visit in a single session? Note that a page only counts once even if visited multiple times during the session.
 */
public class MaxVisitedWebPagesWitaSingleLink {
    public int getMaxVisitableWebpages(int N, int[] L) {

        int max = 0;

        int[] iSolution = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (L[i - 1] > 0) {
                max = Math.max(max, lPass(i - 1, L, new boolean[N + 1], iSolution));
            }
        }
        return max;
    }

    public static int lPass (int i, int[] L, boolean[] visited, int[] iSolution) {

        if (visited[i + 1] || L[i] == 0 || i + 1 > iSolution.length) return 0;
        if (iSolution[i + 1] > 0) return iSolution[i + 1];

        visited[i + 1] = true;
        return iSolution[i + 1] = lPass(L[i] - 1, L, visited, iSolution) + 1;
    }
}