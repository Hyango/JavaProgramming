package codesuixiang.StackAndQueue;

import java.util.*;

public class Solution_20 {
    public boolean isValid(String s) {
        //字符串长度为奇数, false
        if (s.length() % 2 != 0) return false;
        //字符串首字符为右括号,false
        if ((String.valueOf(s.charAt(0))).matches("[\\]\\}\\)]")) return false;
        Stack<Character> stack = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') stack.push(')');
            else if (ch == '{') stack.push('}');
            else if (ch == '[') stack.push(']');
                //接收右括号,但栈已空,没有匹配的括号,false
                //接收右括号,但与栈顶括号不等,false
            else if (stack.isEmpty() || stack.peek() != ch) return false;
            else stack.pop(); //stack.peek() 与 ch相等,出栈
        }
        return stack.isEmpty(); //所有字符均匹配,栈空,true
    }
    
    public static void main(String[] args) {
        String s = "}[{()}]";
        System.out.println(new Solution_20().isValid(s));
    }
    
    
    //leetcode题解 hash解法
    public boolean isValid1(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
    
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    
    
}
