package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_438 {
	public List<Integer> findAnagrams(String s, String p) {
		// 1.使用一个pChars数组保存p中各个单词出现次数
		// 2.使用一个sChars数组保存s的滑动窗口(窗口大小为pLength)中各个单词出现次数
		// 3.每次移动窗口后更新sChars,然后将pChars与sChars进行比较,相同则为异位子串
		List<Integer> list = new ArrayList<>();
		int pLength = p.length();
		int sLength = s.length();
		if (sLength < pLength) return list;
		
		int[] pChars = new int[26];
		int[] sChars = new int[26]; // 存放窗口各个单词出现的次数
		for (int i = 0; i < pLength; i++) {
			pChars[p.charAt(i) - 'a']++;
			sChars[s.charAt(i) - 'a']++;
		}
		if (Arrays.equals(pChars, sChars)) // 不要使用pChars.equals(sChars),其比较的是数组地址
			list.add(0);
		
		for (int startIndex = 1; startIndex < sLength - pLength + 1; startIndex++) {
			int endIndex = startIndex + pLength - 1;
			sChars[s.charAt(startIndex - 1) - 'a']--;
			sChars[s.charAt(endIndex) - 'a']++;
			if (Arrays.equals(pChars, sChars))
				list.add(startIndex);
		}
		return list;
	}
	
	public static void main(String[] args) {
		String s = "abab";
		String p = "ab";
		System.out.println(new Solution_438().findAnagrams(s, p));
	}
}
