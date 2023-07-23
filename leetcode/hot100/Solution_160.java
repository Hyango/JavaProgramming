package leetcode.hot100;

import codesuixiang.LinkedList.ListNode;

public class Solution_160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode curA = headA;
		ListNode curB = headB;
		while (curA != curB) {
			curA = curA == null ? headB : curA.next;
			curB = curB == null ? headB : curA.next;
		}
		return curA;
	}
	
	public static void main(String[] args) {
	
	
	}
}
