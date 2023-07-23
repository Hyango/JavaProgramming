package leetcode.hot100;

import codesuixiang.BinaryTree.TreeNode;

public class Solution_114 {
    public void flatten(TreeNode root) {
        // 递归结束条件
        if (root == null) return;
        // 将左右子树展平
        flatten(root.left);
        flatten(root.right);
        
        // 记录右子树
        TreeNode tmp = root.right;
        // 展平的左子树放在右子树, 并将左子树置为null
        root.right = root.left;
        root.left = null;
        // 找到展平后的左子树的叶子, 拼接上右子树
        TreeNode last = root;
        while (last.right != null)
            last = last.right;
        last.right = tmp;
    }
    
    public static void main(String[] args) {
    
    }
}
