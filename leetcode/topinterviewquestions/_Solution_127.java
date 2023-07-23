package leetcode.topinterviewquestions;

import java.util.*;

public class _Solution_127 {
	/* BFS与DFS两种写法 */
	int least = Integer.MAX_VALUE;
	Set<String> visited; // 用于剪枝,防止成环
	
	/**
	 * DFS, 会出现超时.
	 *
	 * @param i 转换序列的长度
	 */
	private void traverse(String beginWord, String endWord, List<String> wordList, Set<String> visited, int i) {
		if (beginWord.equals(endWord)) {
			least = Math.min(least, i);
			return;
		}
		// 当前单词访问过了,结束递归
		if (visited.contains(beginWord))
			return;
		
		// 前序:将当前单词加入Set
		visited.add(beginWord);
		// 中序:递归
		for (String word : wordList) {
			// 若单词和beginWord只差一个字母,则进入递归
			int dif = 0;
			for (int j = 0; j < word.length(); j++) {
				if (word.charAt(j) != beginWord.charAt(j))
					dif++;
			}
			if (dif == 1)
				traverse(word, endWord, wordList, visited, i + 1);
		}
		// 后序:回溯
		visited.remove(beginWord);
	}
	
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		/* 对于找最短的问题,使用bfs的效率会高 */
		
		// wordList中无endWord,返回0
		if (!wordList.contains(endWord)) {
			return 0;
		}
		visited = new HashSet<>();
		// bfs
		int shortest = bfs(beginWord, endWord, wordList);
		return shortest == 1 ? 0 : shortest;
		
		// dfs
		// least = Integer.MAX_VALUE;
		// traverse(beginWord, endWord, wordList, visited, 1);
		// return least == Integer.MAX_VALUE ? 0 : least;
	}
	
	/**
	 * BFS
	 */
	private int bfs(String beginWord, String endWord, List<String> wordList) {
		int shortest = 1;
		// 队列用于保存当前层的所有word
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		
		while (!queue.isEmpty()) {
			int count = queue.size();
			while (count-- != 0) { // 遍历递归树当前层的word
				String curLevelWord = queue.poll();
				if (endWord.equals(curLevelWord)) // 找到endWord了,返回最短转换序列的长度shortest
					return shortest;
				
				for (String word : wordList) { // 遍历词典,将符合的单词加入队列(成为递归树的下一层)
					if (visited.contains(word)) // 已经访问过,跳过
						continue;
					// 若单词和beginWord只差一个字母,则进入递归
					int dif = 0;
					for (int j = 0; j < word.length(); j++) {
						if (word.charAt(j) != curLevelWord.charAt(j))
							dif++;
					}
					if (dif == 1) {
						visited.add(word);
						queue.add(word);
					}
				}
			}
			shortest++; // 处理完一层,层数加1;
		}
		return 1;
	}
	
	
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordArray = {"hot", "dot", "dog", "lot", "log", "cog"};
		List<String> wordList = new ArrayList<>(Arrays.asList(wordArray));
		System.out.println(new _Solution_127().ladderLength(beginWord, endWord, wordList));
	}
}
