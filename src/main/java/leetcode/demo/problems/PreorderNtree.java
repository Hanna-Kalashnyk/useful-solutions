package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.List;

public class PreorderNtree
{
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(TreeNode root) {
        if(root==null)return list;
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
        return list;
    }
}
