package codesuixiang.LinkedList;

public class Solution_206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null; //指向cur的左边
        ListNode temp = cur; //临时指向cur的右边
        while (cur != null) {
            temp = temp.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    
    public static void main(String[] args) {
        int[] nums = {1};
        ListNode head = new ListNode();
        head = ListNode.arrayToListNode(nums);
        ListNode newHead = new Solution_206().reverseList(head);
        ListNode.printListNode(newHead);
    }
}
