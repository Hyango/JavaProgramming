package leetcode.topinterviewquestions;

import codesuixiang.BinaryTree.TreeNode;

public class Solution_230 {
	// /* 使用一个大顶堆来维护前k小的元素 */
	// PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
	// public int kthSmallest(TreeNode root, int k) {
	// 	traverse(root, k);
	// 	return pq.peek();
	// }
	//
	// private void traverse(TreeNode root, int k) {
	// 	if (root == null) return;
	// 	pq.add(root.val);
	// 	if ((!pq.isEmpty()) && pq.size() > k) {
	// 		pq.poll();
	// 	}
	// 	traverse(root.left, k);
	// 	traverse(root.right, k);
	// }
	
	/* 利用中序遍历的特性 找到第k小的元素*/
	public int kthSmallest(TreeNode root, int k) {
		// 利用 BST 的中序遍历特性
		traverse(root, k);
		return res;
	}
	
	// 记录结果
	int res = 0;
	// 记录当前元素的排名
	int rank = 0;
	void traverse(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		traverse(root.left, k);
		/* 中序遍历代码位置 */
		rank++;
		if (k == rank) {
			// 找到第 k 小的元素
			res = root.val;
			return;
		}
		traverse(root.right, k);
	}
	
	public static void main(String[] args) {
		String nums = "[3,1,4,null,2]";
		TreeNode root = TreeNode.stringToTreeNode(nums);
		int k = 1;
		System.out.println(new Solution_230().kthSmallest(root, k));
	}
}
