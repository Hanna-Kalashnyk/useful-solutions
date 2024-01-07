package leetcode.demo.problems;

public class TwoSumBinaryTrees {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
//Given the roots of two binary search trees, root1 and root2, return true if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.
        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            boolean temp1 = false;
            boolean temp2 = false;
            int curr = root1.val + root2.val;
            if (curr == target) {
                return true;
            }

            if (curr < target) {

                if (root1.right != null) temp1 = twoSumBSTs(root1.right, root2, target);
                if (root2.right != null) temp2 = twoSumBSTs(root1, root2.right, target);
                return temp1 || temp2;
            }
            if (curr > target) {

                if (root1.left != null) temp1 = twoSumBSTs(root1.left, root2, target);
                if (root2.left != null) temp2 = twoSumBSTs(root1, root2.left, target);
                return temp1 || temp2;
            }


            return false;
        }
    }
//[0,-10,10]
//[5,1,7,0,2]
//17
