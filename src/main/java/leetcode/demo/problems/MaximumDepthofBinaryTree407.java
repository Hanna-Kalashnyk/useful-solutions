//Given the root of a binary tree, return its maximum depth.
//
//A binary tree's maximum depth is the number of nodes along
// the longest path from the root node down to the farthest leaf node.

package leetcode.demo.problems;

public class MaximumDepthofBinaryTree407
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
	public int maxDepth(TreeNode root) {
	if ( root == null ) return 0;
	return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}