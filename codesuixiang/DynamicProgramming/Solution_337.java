package codesuixiang.DynamicProgramming;

import codesuixiang.BinaryTree.TreeNode;

public class Solution_337 {
    // 不偷：Max(左孩子不偷，左孩子偷) + Max(右孩子不偷，右孩子偷)
    // root[0] = Math.max(rob(root.left)[0],
    //                    rob(root.left)[1]) + Math.max(rob(root.right)[0],
    //                    rob(root.right)[1])
    // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
    // root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
    public int rob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }
    
    public int[] robAction(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);
        //不偷root
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //偷root
        res[1] = root.val + left[0] + right[0];
        return res;
    }
    
    public static void main(String[] args) {
        String tree = "[4,1,null,2,null,3]  "; //7 is true
        TreeNode root = TreeNode.stringToTreeNode(tree);
        System.out.println(new Solution_337().rob(root));
    }
}
