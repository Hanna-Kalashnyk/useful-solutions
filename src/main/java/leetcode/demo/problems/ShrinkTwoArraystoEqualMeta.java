package leetcode.demo.problems;

import java.io.InputStreamReader;
import java.util.*;
import java.io.BufferedReader;

public class ShrinkTwoArraystoEqualMeta {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        int[] res = new int[tests];
        String[] length;
        String[] arrS;
        String[] brrS;
        int n;
        int m;
        int[] arr;
        int[] brr;
        for (int i = 0; i < tests; i++) {
            length = br.readLine().strip().split(" ");
            n = Integer.parseInt(length[0]);
            m = Integer.parseInt(length[1]);
            arrS = br.readLine().strip().split(" ");
            brrS = br.readLine().strip().split(" ");
            arr = new int[n];
            brr = new int[m];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(arrS[j]);
            }
            for (int k = 0; k < m; k++) {
                brr[k] = Integer.parseInt(brrS[k]);
            }
            res[i] = foundEqualArraysLength(0, 0, arr, brr, 0);
        }
        for (int i = 0; i < tests; i++) {
            System.out.println(res[i]);
        }
    }

    public static int foundEqualArraysLength(int i, int j, int[] arr, int[] brr, int res) {
        while (i < arr.length && j < brr.length) {
            if (arr[i] == brr[j]) {
                res++;
                i++;
                j++;
            } else if (arr[i] > brr[j] && j < brr.length - 1) {
                brr[j + 1] = brr[j] + brr[j + 1];
                j++;
            } else if (arr[i] < brr[j] && i < arr.length - 1) {
                arr[i + 1] = arr[i] + arr[i + 1];
                i++;
            }
        }
        return res == 0 ? -1 : res;
    }
}