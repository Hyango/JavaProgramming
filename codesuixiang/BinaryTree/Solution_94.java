package codesuixiang.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class Solution_94 {
    //中序遍历,递归写法
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }
    
    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    
    //中序遍历,迭代写法
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
    

    
    public static void main(String[] args) {
        String input="[3,9,20,null,null,15,7]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println(inorderTraversal(root));

    }
}
