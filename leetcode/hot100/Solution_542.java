package leetcode.hot100;

import codesuixiang.BinaryTree.TreeNode;

public class Solution_542 {
	private int max;
	
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) return 0;
		dfs(root);
		return max;
	}
	
	private int dfs(TreeNode root) {
		// 返回当前节点左右子树的最长路径
		if (root.left == null && root.right == null) {
			return 0;
		}
		int left, right;
		if (root.left != null) {
			left = dfs(root.left) + 1;
		} else left = 0;
		if (root.right != null) {
			right = dfs(root.right) + 1;
		} else right = 0;
		max = Math.max(max, left + right);
		return Math.max(left, right);
	}
	
	public static void main(String[] args) {
		String nums="[4,2,1,3]";
		TreeNode root = TreeNode.stringToTreeNode(nums);
		System.out.println(new Solution_542().diameterOfBinaryTree(root));
		
	}
}
