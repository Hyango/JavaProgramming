package leetcode.topinterviewquestions;

import java.util.HashMap;
import java.util.Map;

public class Solution_138 {
	public Node copyRandomList(Node head) {
		// 使用一个hash表用于原链表的节点到 深拷贝链表节点的映射
		// 首先遍历原链表的同时构建 深拷贝链表(random先赋值为null),同时将(Node, newNode)存入Hash表
		// 同步遍历原链表 和 深拷贝链表,写入random
		
		if (head == null) return null;
		Map<Node, Node> map = new HashMap<>();
		
		Node newHead = new Node(head.val);
		// 构造深拷贝链表
		Node cur = head;
		Node newCur = newHead;
		map.put(cur, newCur);
		while (cur.next != null) {
			newCur.next = new Node(cur.next.val);
			cur = cur.next;
			newCur = newCur.next;
			map.put(cur, newCur);
		}
		// 填充random
		cur = head;
		newCur = newHead;
		while (cur != null) {
			if (cur.random == null)
				newCur.random = null;
			else
				newCur.random = map.get(cur.random);
			cur = cur.next;
			newCur = newCur.next;
		}
		return newHead;
	}
	
	public static void main(String[] args) {
	
	
	}
	
	static class Node {
		int val;
		Node next;
		Node random;
		
		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}
