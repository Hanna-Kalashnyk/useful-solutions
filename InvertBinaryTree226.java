//Given the root of a binary tree, invert the tree, and return its root.
package leetcode;

public class InvertBinaryTree226
{
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
		public TreeNode invertTree(TreeNode root) {
			if ( root == null) return  null;
			return new TreeNode(root.val, invertTree(root.right), invertTree(root.left));
		}
	}
