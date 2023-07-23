package codesuixiang.LinkedList;

public class Solution_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //让fast先走n步即可
        ListNode dummyHead=new ListNode(0,head);
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        while (n!=0) {  // fast先走n步
            fast=fast.next;
            n--;
        }
        while (fast.next!=null){ //移动至fast指向链尾
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummyHead.next;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int n=2;
        ListNode head = ListNode.arrayToListNode(nums);
        ListNode newHead = new Solution_19().removeNthFromEnd(head, n);
        ListNode.printListNode(newHead);
    }
}
