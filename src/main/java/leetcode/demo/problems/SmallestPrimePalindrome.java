package leetcode.demo.problems;

public class SmallestPrimePalindrome {
    public int primePalindrome(int n) {
        int num = n;
        while (!isPalindrome(num) || !isPrime(num)) {
            num++;
        }
        return num;
    }

    private static boolean isPalindrome(int num) {
        int rev = 0;
        int rest = num;
        while (rest > 0) {
            rev = rev * 10 + rest % 10;
            rest = rest / 10;
        }
        return rev == num;
    }

    private static boolean isPrime(int num) {
        if (num < 2 || num % 2 == 0) return num == 2;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}