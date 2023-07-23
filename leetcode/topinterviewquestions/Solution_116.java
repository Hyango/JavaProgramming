package leetcode.topinterviewquestions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_116 {
	public Node connect(Node root) {
		// 层序遍历填充每一个next
		if (root == null) return root;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int count = queue.size();
			while (count-- != 0) {
				Node cur = queue.poll();
				if (count == 0) {
					cur.next = null;
				} else {
					cur.next = queue.peek();
				}
				if (cur.left != null) queue.offer(cur.left);
				if (cur.right != null) queue.offer(cur.right);
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
	
	
	}
	
	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;
		
		public Node() {
		}
		
		public Node(int _val) {
			val = _val;
		}
		
		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}
	
}

