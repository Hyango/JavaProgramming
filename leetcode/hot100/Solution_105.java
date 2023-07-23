package leetcode.hot100;

import codesuixiang.BinaryTree.Solution_102;
import codesuixiang.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_105 {
	/**
	 * 从前序与中序遍历中构造二叉树
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		TreeNode root = findNode(map,
				preorder, 0, preorder.length - 1,
				inorder, 0, inorder.length - 1);
		return root;
	}
	
	private TreeNode findNode(Map<Integer, Integer> map,
							  int[] preorder, int preBegin, int preEnd,
							  int[] inorder, int inBegin, int inEnd) {
		// 递归结束条件
		if (preBegin > preEnd || inBegin > inEnd) {
			return null;
		}
		
		// 根节点
		int rootIndex = map.get(preorder[preBegin]);
		TreeNode root = new TreeNode(inorder[rootIndex]);
		
		// 	左子树
		int leftLength = rootIndex - inBegin;
		root.left = findNode(map, preorder, preBegin + 1, preBegin + leftLength,
				inorder, inBegin, rootIndex - 1);
		
		// 	右子树
		int rightLength = inEnd - rootIndex;
		root.right = findNode(map, preorder, preEnd - rightLength + 1, preEnd,
				inorder, rootIndex + 1, inEnd);
		return root;
	}
	
	public static void main(String[] args) {
		int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
		TreeNode root = new Solution_105().buildTree(preorder, inorder);
		System.out.println(Solution_102.levelOrder(root));
	}
}
