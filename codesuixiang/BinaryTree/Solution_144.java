package codesuixiang.BinaryTree;

import java.util.*;

public class Solution_144 {
    //前序遍历二叉树,递归写法
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }
    
    public static void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
    
    //前序遍历二叉树,迭代写法
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return list;
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right!=null) stack.add(node.right); //因为是LIFO,所以前序遍历时"右"先进栈
            if(node.left!=null) stack.add(node.left);
        }
        return list;
    }
    
    
    public static void main(String[] args) {
        String input="[3,9,20,10,12,15,7]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println(preorderTraversal(root));
    }
}
