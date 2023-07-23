package leetcode.topinterviewquestions;

import java.util.Arrays;

public class Solution_66 {
	/* 数组太长时,long也会越界
	public int[] plusOne(int[] digits) {
		long num = 0;
		for (int digit : digits) {
			num = num * 10 + digit;
		}
		String s = String.valueOf(num + 1);
		int[] res = new int[s.length()];
		int i = 0;
		for (char c : s.toCharArray()) {
			res[i++] = c - '0';
		}
		return res;
	}*/
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i]++;
				return digits;
			}
		}
		// 当数组中的数字都是9时,结果为10...00
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}
	
	public static void main(String[] args) {
		int[] digits = {9, 9};
		System.out.println(Arrays.toString(new Solution_66().plusOne(digits)));
	}
}
