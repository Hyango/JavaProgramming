package codesuixiang.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1; // 和栈中保持一样元素的队列
    Queue<Integer> queue2; // 辅助队列
    
    public MyStack() {
       
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue2.offer(x); //新元素放在辅助队列
        while (!queue1.isEmpty()) { // 主队列元素移至辅助队列
            queue2.offer(queue1.poll());
        }
        Queue<Integer> queueTemp = queue1; //交换两队列
        queue1 = queue2;
        queue2 = queueTemp;
    }
    
    public int pop() {
        return queue1.poll();
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}