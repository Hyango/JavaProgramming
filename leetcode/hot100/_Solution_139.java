package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Solution_139 {
	public boolean wordBreak(String s, List<String> wordDict) {
		int[] visited = new int[s.length() + 1];
		Arrays.fill(visited, -1);
		return dfs(s, 0, wordDict, visited);
	}
	
	private boolean dfs(String s, int i, List<String> wordDict, int[] visited) {
		// 递归结束条件
		if (i == s.length())
			return true;
		// 遍历每一个word,判断s[i..]是否以word开头
		// 若以word开头,递归判断下一段
		for (String word : wordDict) {
			int nextStart = i + word.length();
			
			if (nextStart > s.length())
				continue;
			if (visited[nextStart] == 0)
				continue;
			if (visited[nextStart] == 1)
				return true;
			if (s.startsWith(word, i)) {
				if (dfs(s, nextStart, wordDict, visited)) {
					visited[i] = 1;
					return true;
				}
				visited[nextStart] = 0;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		List<String> wordDict = new ArrayList<>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
		// String s = "leetcode";
		// List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
		System.out.println(new _Solution_139().wordBreak(s, wordDict));
	}
}
