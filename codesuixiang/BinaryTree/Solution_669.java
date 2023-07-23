package codesuixiang.BinaryTree;

public class Solution_669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //修剪二叉搜索树, 返回值为修剪过左右子树的根节点
        //1.递归结束条件: 遍历到了叶子结点
        if (root == null) return null;
        
        //2.单层递归逻辑
        //  2.1. 如果root.val < low, 那么左子树一定不满足条件(一定小于low), 返回修剪后的右子树
        if (root.val < low)
            return trimBST(root.right, low, high);
        //  2.2. 如果root.val > high, 那么右子树一定不满足条件(一定大于high), 返回修剪后的左子树
        if (root.val > high)
            return trimBST(root.left, low, high);
        
        // 2.3 root.val满足调节,修剪左右子树
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
    
    public static void main(String[] args) {
        String input = "[3,0,4,null,2,null,null,1]";
        int low = 1,high=3;
        TreeNode root = TreeNode.stringToTreeNode(input);
        TreeNode newRoot = new Solution_669().trimBST(root, low, high);
        System.out.println(Solution_102.levelOrder(newRoot));
    }
}
