package leetcode.demo.problems;

/**
 * Give the number of numbers, whose are not bigger than x, and whose digits up to y.
 */
public class AddDigitsCisco {
    public static int digitNumber(int x, int y) {
        return count2(x, y, 0, 0);
    }
    public static int count2(int x, int y, int sum, int digitSum) {
        int count = digitSum == y ? 1 : 0;
        for (int i = sum == 0 ? 1 : 0; i <= 9 && sum * 10 + i <= x && digitSum + i <= y; i++) {
            count += count2(x, y, sum * 10 + i, digitSum + i);
        }
        return count;
    }
}
