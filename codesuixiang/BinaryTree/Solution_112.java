package codesuixiang.BinaryTree;

public class Solution_112 {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        //传入一颗空树的情况
        if(root==null) return false;
        //使用taretSum一次递减完成
        //递归结束条件:该节点为叶子节点,如果targerSum==0返回true,!=0返回false
        if (root.left == null && root.right == null && targetSum-root.val == 0) return true;
        if (root.left == null && root.right == null) return false;
        
        
        //单层递归逻辑
        if (root.left != null) {
            if (hasPathSum(root.left, targetSum - root.val)) return true;
        }
        if(root.right != null){
            if (hasPathSum(root.right, targetSum - root.val)) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int targetSum=22;
        String input = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println(hasPathSum(root, targetSum));
    }
}
