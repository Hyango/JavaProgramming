package codesuixiang.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Solution_145 {
    //后序遍历二叉树
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }
    
    public static void postorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }
    
    public static void main(String[] args) {
        String input="[3,9,20,null,null,15,7]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println(postorderTraversal(root));
    }
}
