package leetcode.hot100;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution_128 {
	public int longestConsecutive(int[] nums) {
		// 使用TreeSet排序,然后删除连续元素并计次
		// 迭代器写法
		Set<Integer> set = new TreeSet<>();
		for (int num : nums) {
			set.add(num);
		}
		
		int longest = 0;
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			// 遍历元素
			// 如果元素的上下连续,则将连续值移除set
			int num = iterator.next();
			if (set.contains(num)) {
				int cur = num;
				int curLongest = 1;
				iterator.remove(); // 移除当前元素,不移除也不影响结果.移除可以保证方法返回时set为空
				// 查找连续的左边
				while (set.contains(cur - 1)) {
					curLongest++;
					cur--;
					iterator.next();
					iterator.remove();
				}
				// 查找连续的右边
				cur = num;
				while (set.contains(cur + 1)) {
					curLongest++;
					cur++;
					iterator.next();
					iterator.remove();
				}
				longest = Math.max(longest, curLongest);
			}
		}
		return longest;
	}
	
	public int longestConsecutive1(int[] nums) {
		// 使用Hashset
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		
		int longest = 0;
		for (int num : nums) {
			if (set.contains(num)) {
				int cur = num;
				int curLongest = 1;
				set.remove(cur);
				// 搜索左边元素并删除
				while (set.contains(cur - 1)) {
					curLongest++;
					cur--;
					set.remove(cur);
				}
				// 	搜索右边元素并删除
				cur = num;
				while (set.contains(cur + 1)) {
					curLongest++;
					cur++;
					set.remove(cur);
				}
				longest = Math.max(longest, curLongest);
			}
		}
		return longest;
	}
	
	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2};
		System.out.println(new Solution_128().longestConsecutive(nums));
	}
}
