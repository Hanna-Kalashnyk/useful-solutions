package leetcode.demo.problems;

public class ArrayRotation {
    public int[] solution(int[] A, int K) {
        int n = A.length;
        int k = K % n;
        if (n == 1 || k == 0) return A;
        int temp = 0;
        int count = 0;
        while (count < k) {
            temp = A[n - 1];
            int t = 0;
            int cur = A[0];
            for (int i = 1; i < n; i++) {
                t = A[i];
                A[i] = cur;
                cur = t;
            }
            A[0] = temp;
            count++;
        }
        return A;
    }
}
