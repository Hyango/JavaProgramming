package leetcode.hot100;

import codesuixiang.LinkedList.ListNode;

//hot100 - 2
public class Solution_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        // 标记是否进位
        int flag = 0;
        //当l1,l2都到链表尾时结束
        while (cur1 != null || cur2 != null) {
            //如果其中一个链表到了结尾,则其加数为0
            int x = cur1 == null ? 0 : cur1.val;
            int y = cur2 == null ? 0 : cur2.val;
            //计算
            int sum = x + y + flag;
            int ge = sum % 10;
            flag = sum / 10;
            //填入结果
            cur.next = new ListNode(ge);
            cur=cur.next;
            //后移,如果已经到尾巴了就不移动了
            cur1 = cur1 == null ? null : cur1.next;
            cur2 = cur2 == null ? null : cur2.next;
        }
        if (flag == 1) {
            cur.next = new ListNode(flag);
        }
        return res.next;
    }
    
    public static void main(String[] args) {
        int[] a = {2, 4, 5};
        ListNode l1 = ListNode.arrayToListNode(a);
        ListNode.printListNode(l1);
        int[] b = {5, 6, 4};
        ListNode l2 = ListNode.arrayToListNode(b);
        ListNode.printListNode(l2);
        
        ListNode res = addTwoNumbers(l1,l2);
        ListNode.printListNode(res);
        
    }
}
