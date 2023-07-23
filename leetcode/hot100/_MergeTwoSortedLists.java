package leetcode.hot100;

import codesuixiang.LinkedList.ListNode;

public class _MergeTwoSortedLists {
    
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        //交换拼接至一条到达链表尾
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        //如果一条为空,则直接拼接另一条剩下的
        if (list1 == null) cur.next = list2;
        else cur.next = list1;
        
        return dummyHead.next;
    }
    
    public static void main(String[] args) {
        int[] a = {1, 2, 4};
        int[] b = {1, 3, 4};
        ListNode list1 = ListNode.arrayToListNode(a);
        ListNode list2 = ListNode.arrayToListNode(b);
        ListNode res=mergeTwoLists(list1,list2);
        ListNode.printListNode(res);
    }
}
