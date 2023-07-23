package leetcode.hot100;

import java.util.Stack;

public class Solution_394 {
	public String decodeString(String s) {
		// 1.将s依次入栈.
		// 2.当入栈元素为"]"时,
		// 	2.1.元素出栈并记录于sb,当出栈元素为"["时停止.
		//  2.2.再次出栈,得到字符串重复次数,将sb中的字符串重复,将结果入栈
		// 4.继续将s入栈,重复2
		// 5.当s中所有元素均被处理后,栈内元素即为结果
		
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		StringBuilder res = new StringBuilder();
		int pointer = 0;
		int length = s.length();
		int repeatNum = 0;
		while (pointer < length) {
			if (s.charAt(pointer) == ']') {
				sb.delete(0, sb.length());
				// 出栈操作
				char ch = stack.pop();
				while (ch != '[') {
					sb.insert(0, ch);
					ch = stack.pop();
				}
				// 计算重复次数
				repeatNum = 0;
				int t = 1;
				while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
					repeatNum = t * (stack.pop() - '0') + repeatNum;
					t *= 10;
				}
				StringBuilder tmp = new StringBuilder(sb);
				for (int i = 0; i < repeatNum - 1; i++) {
					sb.append(tmp);
				}
				for (int i = 0; i < sb.length(); i++) {
					stack.push(sb.charAt(i));
				}
				pointer++;
			} else {
				stack.push(s.charAt(pointer));
				pointer++;
			}
		}
		while (!stack.isEmpty()) {
			res.insert(0, stack.pop());
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		String s = "10[leetcode]";
		System.out.println(new Solution_394().decodeString(s));
		
	}
}
