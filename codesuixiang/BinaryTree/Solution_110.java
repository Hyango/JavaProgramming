package codesuixiang.BinaryTree;

public class Solution_110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight==-1||rightHeight==-1)  return false;
        else return Math.abs(leftHeight - rightHeight) <= 1;
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        
        int left = getHeight(root.left);
        if(left==-1)return -1;
        int right = getHeight(root.right);
        if(right==-1)return -1;
        
        if (Math.abs(left - right) > 1) //不平衡了
            return -1;
        else return Math.max(left, right) + 1;
    }
    
    public static void main(String[] args) {
        String input = "[1,2,2,3,null,null,3,4,null,null,4]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println(new Solution_110().isBalanced(root));
    }
}
