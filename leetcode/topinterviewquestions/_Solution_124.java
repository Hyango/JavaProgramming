package leetcode.topinterviewquestions;

import codesuixiang.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _Solution_124 {
	int max = Integer.MIN_VALUE;
	Map<TreeNode, Integer> visited; // 可以不剪枝,不影响
	public int maxPathSum(TreeNode root) {
		visited = new HashMap<>();
		traverse(root);
		return max;
	}
	
	private int traverse(TreeNode root) { // 计算以root为路径的终点节点时,最大的路径和
		if (root == null) return 0;
		// 剪枝,如果当前节点访问过,直接返回当前节点的最大路径和
		if (visited.containsKey(root))
			return visited.get(root);
		// 中序:遍历左右节点
		int left = Math.max(0, traverse(root.left));
		int right = Math.max(0, traverse(root.right));
		// 后序:1.计算以当前节点为根节点时的最大路径和
		int curVal = root.val;
		max = Math.max(curVal + left + right, max);
		
		// 后序:2.计算以当前节点为路径的终点时,最大的路径和,并作为返回值
		int pathMax = Math.max(left, right) + curVal;
		// 记录结果,用于剪枝
		visited.put(root, pathMax);
		return pathMax;
	}
	
	
	public static void main(String[] args) {
		String input = "[9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6]";
		TreeNode root = TreeNode.stringToTreeNode(input);
		System.out.println(new _Solution_124().maxPathSum(root));
		
	}
}
