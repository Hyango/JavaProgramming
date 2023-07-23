package codesuixiang.BinaryTree;

public class Solution_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //插入即可,无需重构
        if (root == null) return new TreeNode(val);
        
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        return root;
    }
    
    public static void main(String[] args) {
        String input = "[20,6,25,5,15,23,28,null,null,13,16]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        TreeNode newRoot = new Solution_701().insertIntoBST(root, 1);
        System.out.println(Solution_102.levelOrder(newRoot));
    }
}
