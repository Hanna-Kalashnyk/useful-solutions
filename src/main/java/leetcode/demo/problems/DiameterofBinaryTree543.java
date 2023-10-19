//Given the root of a binary tree, return the length of the diameter of the tree.
//
//The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//
//The length of a path between two nodes is represented by the number of edges between them.
package leetcode.demo.problems;

public class DiameterofBinaryTree543
{
	int rez;
	
	public int diameterOfBinaryTree(TreeNode root)
	{
		if (root == null)
			return 0;
		else
		{
			int leftHight = height(root.left);
			int rightHight = height(root.right);
			return Math.max(leftHight + rightHight,
				Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
		}
	}
	
	private int height(TreeNode node)
	{
		int hight = 0;
		if (node == null)
			return 0;
		else
		{
			int lh = height(node.left);
			int rh = height(node.right);
			if (lh > rh)
			{
				return lh + 1;
			}
			else
			{
				return rh + 1;
			}
		}
	}
	
	public int diameterOfBinaryTree2(TreeNode root)
	{
		if (root == null) return 0;
	int dia1 = diameterOfBinaryTree(root.right);
	int dia2 = diameterOfBinaryTree(root.left);
	int dia3 = depth(root.left) + depth(root.right);
        return Math.max(dia3, Math.max(dia1, dia2));
}
	
	public int depth (TreeNode root) {
		if (root == null) return 0;
		int leftone = depth(root.left);
		int rightone = depth(root.right);
		return Math.max(leftone, rightone) + 1;
	}
}
