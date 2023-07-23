package leetcode.topinterviewquestions;

import java.util.HashMap;
import java.util.Map;

public class Solution_13 {
	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int current = map.get(ch); // 获取当前罗马字符对应的数字
			// 再判断一下是否是六种特殊情况,若是,则更新current
			if (i + 1 < s.length()) { // i不是最后一个字符时,才可能存在IX,IV这样的情况
				if (ch == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
					current = s.charAt(i + 1) == 'V' ? 4 : 9;
					i++; // i需要后移两格
				} else if (ch == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
					current = s.charAt(i + 1) == 'L' ? 40 : 90;
					i++; // i需要后移两格
				} else if (ch == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
					current = s.charAt(i + 1) == 'D' ? 400 : 900;
					i++; // i需要后移两格
				}
			}
			res += current;
		}
		return res;
	}
	
	public static void main(String[] args) {
		String s = "MCMXCIV";
		System.out.println(new Solution_13().romanToInt(s));
		
	}
}
