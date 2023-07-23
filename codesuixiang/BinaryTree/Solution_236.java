package codesuixiang.BinaryTree;

public class Solution_236 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归结束条件
        if (root == null || root == p || root == q) return root;
        //递归
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //找到公共节点
        if (left != null && right != null) return root;
        else if (left != null && right == null) return left;
        else if (left == null && right != null) return right;
        else return null;
    }
    
    public static void main(String[] args) {
        String input = "[3,5,1,6,2,0,8,null,null,7,4]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        TreeNode p = root.left.left;
        TreeNode q = root.left.right;
        System.out.println(lowestCommonAncestor(root, p, q).val);
        
    }
}
