package codesuixiang.StackAndQueue;

import java.util.Stack;

public class Solution_150 {
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
//        char ch; // 不能用char来接收字符,如果数字>9,则无法处理.
        for (String token : tokens) {
            //使用String的equals方法判断字符串
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/": {
                    int temp1 = stack.pop();
                    int temp2 = stack.pop();
                    stack.push(temp2 / temp1);
                    break;
                }
                default:
                    stack.push(Integer.valueOf(token)); // Integer.valueOf()将字符串数字转为int
            }
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution_150().evalRPN(tokens));
    }
}
