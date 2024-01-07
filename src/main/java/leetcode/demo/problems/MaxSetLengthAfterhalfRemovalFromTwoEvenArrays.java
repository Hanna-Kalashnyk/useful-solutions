package leetcode.demo.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 100150. Maximum Size of a Set After Removals
 * User Accepted:133
 * User Tried:300
 * Total Accepted:133
 * Total Submissions:422
 * Difficulty:Medium
 * You are given two 0-indexed integer arrays nums1 and nums2 of even length n.
 *
 * You must remove n / 2 elements from nums1 and n / 2 elements from nums2.
 * After the removals, you insert the remaining elements of nums1 and nums2 into a set s.
 *
 * Return the maximum possible size of the set s.
 */
public class MaxSetLengthAfterhalfRemovalFromTwoEvenArrays {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int res = 0;
        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());

        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        System.out.println("set1.size()" + set1.size());
        System.out.println("set2.size()" + set2.size());

        Set<Integer> set = new HashSet<Integer>();
        set.addAll(set1);
        set.addAll(set2);
        if (set1.size() <= n / 2 && set2.size() <= n / 2) {
            return set.size();
        } else if (set2.size() > n / 2 && set1.size() <= n / 2) {
            for (Integer num : set1) {
                if (set2.contains(num)) set2.remove(num);
            }
            if (set2.size() >= n / 2) {
                return set1.size() + n / 2;
            } else {
                set1.addAll(set2);
                return set1.size();
            }
        } else if (set1.size() > n / 2 && set2.size() <= n / 2) {
            for (Integer num : set2) {
                if (set1.contains(num)) set1.remove(num);
                System.out.println(num);
            }
            if (set1.size() >= n / 2) {
                System.out.println("set1.size()" + set1.size());
                System.out.println("set2.size()" + set2.size() + "       set2.size() + n/2  " + set2.size() + n / 2);
                return set2.size() + n / 2;

            } else {
                set2.addAll(set1);
                return set2.size();
            }
        } else {
            int delta = set1.size() + set2.size() - set.size();
            return res = Math.min(set1.size() + set2.size() - delta, n);
        }

    }
}
