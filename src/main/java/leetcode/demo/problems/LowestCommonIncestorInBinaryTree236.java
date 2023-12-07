package leetcode.demo.problems;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonIncestorInBinaryTree236 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (isAncestor(root, p) && isAncestor(root, q)
                && (!isAncestor(root.left, p) || !isAncestor(root.left, q))
                && (!isAncestor(root.right, p) || !isAncestor(root.right, q))) return root;

        if (root.left != null) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left != null) return left;
        }

        if (root.right != null) {
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right != null) return right;
        }
        return null;

    }

    public boolean isAncestor(TreeNode root, TreeNode p) {
        boolean left = false;
        boolean right = false;
        if (root == p) return true;
        if (root != null && root.left != null) left = isAncestor(root.left, p);
        if (root != null && root.right != null) right = isAncestor(root.right, p);
        return left || right;
    }
}