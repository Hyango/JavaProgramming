package codesuixiang.LinkedList;

public class Solution_24 {
    public ListNode swapPairs(ListNode head) {
        //笔记有详细过程
        if(head==null)  return null;
        ListNode dummyHead = new ListNode(0, head);
        ListNode slow = dummyHead;
        ListNode cur = head;
        ListNode fast = cur.next;
        while (cur != null && cur.next != null) {
            fast = cur.next;
            //交换节点(修改指针指向)
            slow.next = cur.next;
            cur.next = fast.next;
            fast.next = cur;
            //移动指针
            slow = cur;
            cur = cur.next;
        }
        return dummyHead.next;
    }
    
    public static void main(String[] args) {
        int[] nums = {1};
        ListNode head = ListNode.arrayToListNode(nums);
        ListNode newHead = new Solution_24().swapPairs(head);
        ListNode.printListNode(newHead);
        
    }
    
}
