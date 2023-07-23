package leetcode.hot100;

import codesuixiang.LinkedList.ListNode;

public class _Solution_148 {
    //排序链表
    /*
    * !!! 学会cut()和merge()两个方法的使用 !!!
    * */
    public ListNode sortList(ListNode head) {
        //加一个头结点，处理边界节点时，逻辑相同
        ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
        dummyHead.next = head;
    
        //计算长度
        int length = 0;
        ListNode work = head;
        while (work != null) {
            work = work.next;
            length++;
        }
    
        ListNode tail = dummyHead;
        //每次步长*2
        for (int step = 1; step < length; step <<= 1) {
//            ListNode.printListNode(dummyHead.next);
            work = dummyHead.next;
            tail = dummyHead;//记录每一趟归并的结果，下趟归并时重置tail
            while (work != null) {
                /*
                 * 第一句left->@->@->@->@->@->@->null
                 * 第二句left->@->@->null   right->@->@->@->@->null
                 * 第三句left->@->@->null   right->@->@->null   work->@->@->null
                 */
                ListNode left = work;
                ListNode right = cut(left, step);//将链表拆成两部分，左边为step长链表，右边为剩余链表
                work = cut(right, step);//这步执行完毕，left为step链表，right为step链表，work为剩余链表，下一趟排序的基础链表
                
                tail.next = merge(left, right);//将上述left和right合并,得到的链表长度为step<<2
                //总是把tail移到当前链表的最后一个位置，用于拼接下一趟循环产生的结果
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return dummyHead.next;
    }
    
    //作用：在step位置断链，并返回后面部分的链头
    public ListNode cut(ListNode head, int step) {
        while (--step != 0 && head != null) { //注意:这里是--step!!
            head = head.next;
        }
        //如果链表不够step长，就返回空
        if (head != null) {
            ListNode result = head.next;
            head.next = null;
            return result;
        }else {
            return null;
        }
    }
    
    //归并两条链表
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode work = new ListNode(0);
        ListNode head = work;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                work.next = l1;
                l1 = l1.next;
            } else {
                work.next = l2;
                l2 = l2.next;
            }
            work = work.next;
        }
        if (l1 != null) {
            work.next = l1;
        }
        if (l2 != null) {
            work.next = l2;
        }
        return head.next;
    }
    
    public static void main(String[] args) {
        int[] nums={-1,5,9,4,0,8,7,3,2,1};
        ListNode head = ListNode.arrayToListNode(nums);
        head = new _Solution_148().sortList(head);
        ListNode.printListNode(head);
    }
}
