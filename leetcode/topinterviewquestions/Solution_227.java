package leetcode.topinterviewquestions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution_227 {
	public int calculate(String s) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		char preSign = '+';
		int num = 0;
		int n = s.length();
		for (int i = 0; i < n; ++i) {
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			}
			if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
				//  ||的左边 <=> 当前字符为运算符,对其前面的运算符进行运算
				//  ||的右边 <=> 最后一个字符了,也进行运算
				switch (preSign) {
					case '+':
						stack.push(num);
						break;
					case '-':
						stack.push(-num);
						break;
					case '*':
						stack.push(stack.pop() * num);
						break;
					default:
						stack.push(stack.pop() / num);
				}
				preSign = s.charAt(i);
				num = 0;
			}
		}
		int ans = 0;
		while (!stack.isEmpty()) {
			ans += stack.pop();
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String s = "3+2*2";
		System.out.println(new Solution_227().calculate(s));
		
	}
	
	public int calculate0(String s) {
		// 该写法只适用于一位数的运算. 两位数的运算会出错
		s = s.trim();
		char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < chars.length; i++) { // 所有元素入栈,同时将乘除法完成计算
			char ch = chars[i];
			if (ch == ' ') continue;
			int temp = 0;
			if (!stack.isEmpty() && stack.peek() == '*') {
				stack.pop();
				int a = stack.pop() - '0';
				temp = a * (ch - '0');
				stack.push((char) (temp + '0'));
			} else if (!stack.isEmpty() && stack.peek() == '/') {
				stack.pop();
				int a = stack.pop() - '0';
				temp = a / (ch - '0');
				stack.push((char) (temp + '0'));
			} else {
				stack.push(ch);
			}
		}
		
		int res = 0;
		int a = 0, b = 0;
		a = stack.pop() - '0';
		while (!stack.isEmpty()) { // 完成加减法运算
			char ch = stack.pop();
			b = stack.pop() - '0';
			if (ch == '+') {
				stack.push((char) (b + a + '0'));
			} else if (ch == '-') {
				stack.push((char) (b - a + '0'));
			}
			a = stack.pop() - '0';
		}
		return a;
	}
	
}
