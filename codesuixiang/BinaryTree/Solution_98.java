package codesuixiang.BinaryTree;

//验证二叉搜索树:满足节点间的大小关系
//方法1:将二叉树中序遍历加入数组,如果是二叉搜索树,则数组有序,前一个元素 < 后一个元素

import java.util.ArrayList;

public class Solution_98 {
    //方法1:将二叉树中序遍历加入数组,如果是二叉搜索树,则数组有序,前一个元素 < 后一个元素
    static ArrayList<Integer> list = new ArrayList<>();
    
    public static boolean isValidBST(TreeNode root) {
        inorder(root);
        if (list.size() == 1) return true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1))
                return false;
        }
        return true;
    }
    
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
        return;
    }
    
    
    public static void main(String[] args) {
        String input = "[0]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println(isValidBST(root));
    }
}
