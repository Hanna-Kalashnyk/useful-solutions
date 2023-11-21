package leetcode.demo.problems;

import java.util.*;

public class TaskScheuler621 {
    /**
     * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
     * Tasks could be done in any order. Each task is done in one unit of time. For each unit of time,
     * the CPU could complete either one task or just be idle.
     * <p>
     * However, there is a non-negative integer n that represents the cooldown period between two same tasks
     * (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
     * <p>
     * Return the least number of units of times that the CPU will take to finish all the given tasks.
     */
//    public int leastInterval(char[] tasks, int n) {
//        int[] arr = new int[26];
//        for (int i = 0; i < tasks.length; i++) {
//            int temp = tasks[i] - 'A';
//            arr[temp]++;
//        }
//        int ct = 1;
//        Arrays.sort(arr);
//        int maxi = arr[arr.length - 1];
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i] == maxi) ct++;
//        }
//        int ans = (maxi - 1) * (n + 1) + ct;
//        return Math.max(ans, tasks.length);
//    }

    public int leastInterval1(char[] tasks, int n) {

        int[] chars = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            chars[tasks[i] - 'A']++;
        }
        Arrays.sort(chars);
        int extra = 1;
        for (int j = 0; j < 25; j++) {
            if (chars[j] == chars[25]) {
                extra++;
            }
        }
        return Math.max(tasks.length, (chars[25] - 1) * (n + 1) + extra);
    }
}