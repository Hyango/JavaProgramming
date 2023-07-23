package codesuixiang.BinaryTree;

public class Solution_538 {
    static int preVal = 0;
    
    public static TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }
    
    public static void traversal(TreeNode root) {
        //右中左遍历即可
        if (root == null) return;
        traversal(root.right);
        root.val += preVal;
        preVal = root.val;
        traversal(root.left);
    }
    
    public static void main(String[] args) {
        String input="[0,null,1]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        convertBST(root);
    
        System.out.println(Solution_102.levelOrder(root));
    }
}
