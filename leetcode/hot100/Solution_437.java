package leetcode.hot100;

import codesuixiang.BinaryTree.TreeNode;

public class Solution_437 {
	private int count = 0;
	
	public int pathSum(TreeNode root, int targetSum) {
		if (root == null) return 0;
		sum(root, targetSum);
		pathSum(root.left, targetSum);
		pathSum(root.right, targetSum);
		return count;
	}
	
	private void sum(TreeNode root, long targetSum) {
		// 计算以root为结尾,是否存在何为targetSum的路径
		if (root == null) return;
		long newSum=targetSum-root.val;
		if (newSum == 0) {
			count++;
		}
		sum(root.left, newSum);
		sum(root.right, newSum);
	}
	public static void main(String[] args) {
		int targetSum = 0;
		String nums = "[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]";
		TreeNode root = TreeNode.stringToTreeNode(nums);
		System.out.println(new Solution_437().pathSum(root, targetSum));
		
	}
}
