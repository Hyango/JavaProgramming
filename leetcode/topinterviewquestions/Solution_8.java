package leetcode.topinterviewquestions;

public class Solution_8 {
	public int myAtoi(String s) {
		if (s == null || s.length() == 0) return 0;
		int i = 0;
		int sign = 1;
		int result = 0;
		// 丢弃前导空格
		while (i < s.length() && s.charAt(i) == ' ') i++;
		
		// 判断符号
		if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			sign = (s.charAt(i) == '-') ? -1 : 1;
			i++;
		}
		// 转换数字
		while (i < s.length() && Character.isDigit(s.charAt(i))) {
			int digit = s.charAt(i) - '0';
			// 检查是否溢出
			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
				return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			result = result * 10 + digit;
			i++;
		}
		return result * sign;
	}
	
	public static void main(String[] args) {
	 	String s = "4193 with words";
		System.out.println(new Solution_8().myAtoi(s));
		
	}
}
