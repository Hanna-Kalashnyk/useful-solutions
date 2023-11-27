package leetcode.demo.problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 */
public class FindKClosestElements658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int count = k;
        List<Integer> list = new ArrayList<>();
        int ind = Arrays.binarySearch(arr, x);
        if (ind < 0) {
            ind = -ind - 1;
        }
        list.add(arr[ind]);
        count--;

        collectListK(list, arr, x, ind, 1, 1, count);
        Collections.sort(list);
        return list;
    }

    private static void collectListK(List<Integer> list, int[] arr, int x, int ind, int i, int j, int count) {
        if (ind - i < 0) {
            while (count > 0) {
                list.add(arr[ind + j]);
                j++;
                count--;
            }
            return;
        }
        if (ind + j >= arr.length) {
            while (count > 0) {
                list.add(arr[ind - i]);
                i++;
                count--;
            }
            return;
        }
        if (count > 0) {
            int low = arr[ind - i];
            int high = arr[ind + j];
            if (Math.abs(low - x) > Math.abs(high - x)) {
                list.add(high);
                collectListK(list, arr, x, ind, i, j + 1, count - 1);
            } else {
                list.add(low);
                collectListK(list, arr, x, ind, i + 1, j, count - 1);
            }
        }
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        if (k == arr.length) return Arrays.stream(arr).boxed().collect(Collectors.toList());
        int l = 0;
        int h = arr.length - 1;
        List<Integer> res = new ArrayList<>();
        while (h - l > k) {
            int m = (l + h) / 2;
            if (x - arr[m] > arr[m] - x) {
                l++;
            } else {
                h--;
            }
        }
        for (int i = l; i < h; i++) {
            res.add((Integer) arr[i]);
        }
        Collections.sort(res);
        return res;
    }
}

