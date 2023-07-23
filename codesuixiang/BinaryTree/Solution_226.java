package codesuixiang.BinaryTree;

public class Solution_226 {
    //翻转二叉树
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    
    public static void main(String[] args) {
        String input="[3,9,20,10,12,15,7]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println(Solution_102.levelOrder(root));
        
        root=invertTree(root);
        System.out.println(Solution_102.levelOrder(root));
    }
}
