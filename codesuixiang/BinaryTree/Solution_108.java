package codesuixiang.BinaryTree;

public class Solution_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = dfs(nums, 0, nums.length - 1);
        return root;
    }
    private TreeNode dfs(int[] nums, int left, int right) {
        //1. 递归结束条件
        if (left > right) return null;
        //2. 单层递归逻辑
        //  2.1 建根节点
        int mid = (right + left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        //  2.2 找左孩子,找右孩子
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }
    
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode newRoot = new Solution_108().sortedArrayToBST(nums);
        System.out.println(Solution_102.levelOrder(newRoot));
    }
}
