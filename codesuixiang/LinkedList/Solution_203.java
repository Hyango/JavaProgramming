package codesuixiang.LinkedList;

public class Solution_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val)
                cur.next = cur.next.next;
            else cur = cur.next;
        }
        return dummyHead.next;
    }
    
    public static void main(String[] args) {
        int val = 6;
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = ListNode.arrayToListNode(nums);
        
        ListNode result = new Solution_203().removeElements(head, val);
        ListNode.printListNode(result);
    }
}

