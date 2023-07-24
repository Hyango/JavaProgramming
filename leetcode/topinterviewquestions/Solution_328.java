package leetcode.topinterviewquestions;

import codesuixiang.LinkedList.ListNode;

public class Solution_328 {
	/*
	 * 思路: 每次分离一对奇偶节点.
	 * 过程:1.每次判断偶节点和其下一个节点不为空,分离当前奇偶节点,并向后移动.
	 * */
	public ListNode oddEvenList(ListNode head) {
		if (head == null) return null;
		else if (head.next == null || head.next.next == null) return head;
		ListNode evenHead = head.next;
		ListNode curOdd = head, curEven = head.next;
		while (curEven != null && curEven.next != null) {
			curOdd.next = curEven.next;
			curOdd = curOdd.next;
			curEven.next = curOdd.next;
			curEven = curEven.next;
		}
		curOdd.next = evenHead;
		return head;
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 1, 3, 5, 6, 4, 7};
		ListNode head = ListNode.arrayToListNode(nums);
		ListNode res = new Solution_328().oddEvenList(head);
		ListNode.printListNode(res);
	}
}
