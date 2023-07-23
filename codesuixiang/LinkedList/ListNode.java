package codesuixiang.LinkedList;

public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode() {
    }
    
    public ListNode(int val) {
        this.val = val;
    }
    
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    
    public static ListNode arrayToListNode(int[] nodeValues) {
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static void printListNode(ListNode head){
        if (head==null){
            System.out.printf("head is null!");
            return;
        }
        ListNode cur =head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur=cur.next;
        }
        System.out.println();
    }
}

