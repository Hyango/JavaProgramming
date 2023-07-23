package leetcode;

import java.util.*;

public class Solution_752 {
	/*
	广度优先BFS, https://labuladong.github.io/algo/di-ling-zh-bfe1b/bfs-suan-f-463fd/
	*/
	
	public int openLock(String[] deadends, String target) {
		/* BFS的每一层,表示操作了一次*/
		// 记录死亡数字
		Set<String> deads = new HashSet<>();
		deads.addAll(Arrays.asList(deadends));
		// 记录已经穷举过的密码,防止走回头路(如0000->...->0009->0000)
		Set<String> visited = new HashSet<>();
		// BFS用到的队列,用于记录每一层
		Queue<String> queue = new LinkedList<>();
		
		int step = 0;
		queue.offer("0000");
		visited.add("0000");
		
		while (!queue.isEmpty()) {
			int count = queue.size();
			// 当前队列里的节点进行一次操作.
			for (int i = 0; i < count; i++) {
				String cur = queue.poll();
				// 判断当前节点是否为死亡数字,如果是,则不要要进行调节操作,直接下一个节点
				if (deads.contains(cur)) {
					continue;
				}
				// 如果当前节点为目标节点,则返回需要拨动的次数
				if (cur.equals(target)) {
					return step;
				}
				
				// 拨动一次并加入队列
				for (int j = 0; j < 4; j++) {
					String up = plusOne(cur, j);
					if (!visited.contains(up)) {
						queue.offer(up);
						visited.add(up);
					}
					
					String down = minusOne(cur, j);
					if (!visited.contains(down)) {
						queue.offer(down);
						visited.add(down);
					}
				}
			}
			step++;
		}
		return -1;
	}
	
	private String plusOne(String s, int j) {
		char[] chars = s.toCharArray();
		chars[j] = chars[j] == '9' ? '0' : (char) (chars[j] + 1);
		return new String(chars);
	}
	
	private String minusOne(String s, int j) {
		char[] chars = s.toCharArray();
		chars[j] = chars[j] == '0' ? '9' : (char) (chars[j] - 1);
		return new String(chars);
	}
	
	public static void main(String[] args) {
		String[] deadends = {"0201","0101","0102","1212","2002"};
		String target="0202";
		System.out.println(new Solution_752().openLock(deadends, target));
	}
}
