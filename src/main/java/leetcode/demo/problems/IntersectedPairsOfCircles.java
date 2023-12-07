package leetcode.demo.problems;

import java.util.*;

/**
 * Task 1
 * <p>
 * Select Programming Language, Java 8 selected
 * Java 8
 * Programming Language
 * <p>
 * Task description
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers,
 * specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].
 * <p>
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point
 * (assuming that the discs contain their borders).
 */
public class IntersectedPairsOfCircles {
    public int solution(int[] A) {
        int n = A.length;
        int sum = 0;
        List<int[]> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] circle = new int[2];
            circle[0] = i - A[i];
            circle[1] = i + A[i];
            map.add(circle);
        }
        for (int i = 0; i < map.size() - 1; i++) {
            int[] cur = map.get(i);
            Iterator<int[]> iterator= map.listIterator(i);
            while (iterator.hasNext() && iterator.next()[0] <= cur[1]) {
                System.out.println(sum++);
            }
            sum--;
         //   cur[0] = Integer.MAX_VALUE;
          //  cur[1] = Integer.MAX_VALUE;
        }
        return  sum;
    }
}
