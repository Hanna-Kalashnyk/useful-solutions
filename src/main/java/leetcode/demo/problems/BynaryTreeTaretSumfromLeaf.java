package leetcode.demo.problems;

import java.util.*;

public class BynaryTreeTaretSumfromLeaf {


    public class Solution {

        public static void main(String [] args) {
            // you can write to stdout for debugging purposes, e.g.
            System.out.println("This is a debug message");
        }

        class Node {
            Node left;
            Node right;
            Integer val;

            Node(Integer val, Node left, Node right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        public static List<Integer> targetCollect (Node root, int target) {
            List<Integer> res = new ArrayList();
            Stack stack  = new Stack<Integer>();

            recursion(root, target, stack, res);
            return res.size() == 0 ? null : res;
        }


        public static List<Integer> recursion (Node root, int target, Stack<Integer> stack, List<Integer> res) {
            if (root.right == null && root.left == null && 0 == target) {
                return tryToCollect(target, stack, res);
            }
            // sum += root.val;
            stack.push(root.val);
            int value = root.val;
            recursion(root.left, target - value, stack, res);
            recursion(root.right, target - value, stack, res);
            return tryToCollect(target, stack, res);
        }

        public static List<Integer> tryToCollect(int target, Stack<Integer> stack, List<Integer> res) {
            int start = stack.pop();
            res.add(start);
            int sum = start;
            while (!stack.isEmpty()){
                int next = stack.pop();
                if (sum + next > target) {
                    return new ArrayList<Integer>();
                }
                if (sum + next < target) {
                    sum += next;
                    res.add(next);
                }
                if (sum + next == target) {
                    res.add(next);
                    return res;
                }
            }
            return res;
        }
    }
}
