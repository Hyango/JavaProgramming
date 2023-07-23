package codesuixiang.BinaryTree;

public class Solution_617 {
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null)return root2;
        if(root2==null)return root1;
        
        root1.val+=root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
    
    public static void main(String[] args) {
        String input1="[3,9,20,10,12,15,7]";
        TreeNode root1 = TreeNode.stringToTreeNode(input1);
        String input2="[1,2,3,null,12,null,7]";
        TreeNode root2 = TreeNode.stringToTreeNode(input2);
        TreeNode root = mergeTrees(root1,root2);
        System.out.println(new Solution_102().levelOrder(root));
    }
}
