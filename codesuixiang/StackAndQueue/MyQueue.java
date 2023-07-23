package codesuixiang.StackAndQueue;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    
    public MyQueue() {
        stackIn = new Stack<>(); // 负责进栈
        stackOut = new Stack<>(); // 负责出栈
    }
    
    public void push(int x) {
        stackIn.push(x);
    }
    
    public int pop() {
        movestackIn();
        return stackOut.pop();
    }
    
    public int peek() {
        movestackIn();
        return stackOut.peek();
    }
    
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
    
    //先判断stackOut是否为空,不为空,则可直接出栈. 减少了stackIn与stackOut的来回移动.
    private void movestackIn() {
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()) {
            Integer inToOut = stackIn.pop();
            stackOut.push(inToOut);
        }
    }
}
