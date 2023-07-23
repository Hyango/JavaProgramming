package codesuixiang.BinaryTree;

import java.util.*;

public class Solution_104 {
    //递归法
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return getDepth(root);
    }
    
    public static int getDepth(TreeNode root) {
        //相当于后序遍历,其实求出的结果是高度.但对于根节点来说其高度与深度一样
        if (root == null) return 0;
        
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        int depth = Math.max(left, right) + 1;
        return depth;
    }
    
    
    //层序遍历法.
    public static int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //当前层节点数
            int count=queue.size();
            depth++;
            while(count>0){
                //当前的节点依次出队列
                TreeNode node= queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                count--;
            }
        }
        return depth;
    }
    
    
    public static void main(String[] args) {
        String input = "[3,9,20,null,null,15,7,8]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println(maxDepth(root));
    }
}
