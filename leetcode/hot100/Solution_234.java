package leetcode.hot100;

import codesuixiang.LinkedList.ListNode;

import java.util.Stack;

public class Solution_234 {
	public boolean isPalindrome(ListNode head) {
		if (head.next==null) return true;
		ListNode dummyHead = new ListNode(0, head);
		ListNode slow = dummyHead;
		ListNode fast = dummyHead;
		// 定义快慢指针,使用slow找到中间节点
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// 利用栈来判断是否为回文串
		Stack<Integer> stack=new Stack<>();
		ListNode tmp=head;
		if (fast == null) {
			// 若fast==null,证明链表节点数为奇数,slow指向中间节点
			// 将slow节点前的所有节点入栈
			while (tmp != slow) {
				stack.push(tmp.val);
				tmp = tmp.next;
			}
			tmp = tmp.next; // 将tmp指向slow后一个节点
		}
		else {
			// 若fast!=null,链表节点数为偶数,且slow指向链表前半段的末尾.
			// 将链表的前半段一次入栈
			while (tmp != slow.next) {
				stack.push(tmp.val);
				tmp = tmp.next;
			}
		}
		// 将链表后半段出栈
		while (!stack.isEmpty()){
			if (tmp.val==stack.peek()){
				stack.pop();
				tmp=tmp.next;
			}
			else return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
	
	
	}
}
