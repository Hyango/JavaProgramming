package codesuixiang.StackAndQueue;

import java.util.Stack;

public class Solution_1047 {
    
    public String removeDuplicates(String s) {
        char ch;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (stack.isEmpty() || ch != stack.peek()) stack.push(ch);
            else stack.pop();
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(new Solution_1047().removeDuplicates(s));
    }
}

