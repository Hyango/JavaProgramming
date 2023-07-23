package leetcode.topinterviewquestions;

import codesuixiang.BinaryTree.TreeNode;

import java.util.*;


public class Solution_103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean reverseFlag = false; // 标记是否需要翻转层
		while (!queue.isEmpty()) {
			int count = queue.size();
			path.clear();
			while (count-- != 0) {
				TreeNode cur = queue.poll();
				path.add(cur.val);
				if (cur.left != null) queue.offer(cur.left);
				if (cur.right != null) queue.offer(cur.right);
			}
			if (reverseFlag) {
				Collections.reverse(path);
			}
			res.add(new ArrayList<>(path));
			reverseFlag = !reverseFlag;
		}
		return res;
	}
	
	public static void main(String[] args) {
		String input = "[3,9,20,1,8,15,7]";
		TreeNode root = TreeNode.stringToTreeNode(input);
		System.out.println(new Solution_103().zigzagLevelOrder(root));
		
	}
}
