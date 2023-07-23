package codesuixiang.BinaryTree;

public class Solution_101 {
    
    public static boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return compare(root.left,root.right);
    }
    
    public static boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;
        
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        boolean isSame = outside && inside;
        return isSame;
    }
    
    
    public static void main(String[] args) {
        String input = "[3,9,9,null,15,15,null]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println(isSymmetric(root));
    }
    
    
    /**
     * 递归法，相比求MaxDepth要复杂点
     * 因为最小深度是从根节点到最近**叶子节点**的最短路径上的节点数量
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        // 左右结点都不为null
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
