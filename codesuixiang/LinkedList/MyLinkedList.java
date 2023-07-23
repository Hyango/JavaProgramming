package codesuixiang.LinkedList;

public class MyLinkedList {
    //Solution_707
    int size;
    MyListNode dummyHead;
    
    public MyLinkedList() {
        size = 0;
        dummyHead = new MyListNode(0);
    }
    
    public int get(int index) {
        if (index >= size || index < 0) return -1;
        MyListNode cur = dummyHead;
        while (index >= 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;
        MyListNode cur = dummyHead;
        while (index > 0) {//循环在cur指向index的前一个元素时停止
            cur = cur.next;
            index--;
        }
        MyListNode insertNode = new MyListNode(val);
        insertNode.next = cur.next;
        cur.next = insertNode;
        size++;
        return;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) return;
        MyListNode cur = dummyHead;
        while (index > 0) {//循环在cur指向index的前一个元素时停止
            cur = cur.next;
            index--;
        }
        cur.next = cur.next.next;
        size--;
        return;
    }
    
    
}

class MyListNode {
    int val;
    MyListNode next;
    
    public MyListNode(int val) {
        this.val = val;
    }
}