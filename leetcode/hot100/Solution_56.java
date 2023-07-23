package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_56 {
	public int[][] merge(int[][] intervals) {
		// 按照区间的左端点排序，那么在排完序的列表中，可以合并的区间一定是连续的
		
		// 首先，将列表中的区间按照左端点升序排序。
		// 然后将第一个区间加入 merged 数组中，并按顺序依次考虑之后的每个区间：
		// 1.如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，
		// 	可以直接将这个区间加入数组 merged 的末尾；
		// 2.否则，它们重合，需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。
		
		if (intervals.length == 0) return new int[0][2];
		// 对起点终点进行排序
		Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
		int i = 0;
		
		List<int[]> res = new ArrayList<>();
		while (i < intervals.length) {
			int left = intervals[i][0];
			int right = intervals[i][1];
			// 如果有重叠，循环判断哪个起点满足条件
			while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
				i++;
				right = Math.max(right, intervals[i][1]);
			}
			// 将现在的区间放进res里面
			res.add(new int[]{left, right});
			// 接着判断下一个区间
			i++;
		}
		return res.toArray(new int[0][]);
	}
	
	public static void main(String[] args) {
		int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
		int[][] res = new Solution_56().merge(intervals);
		System.out.println(Arrays.deepToString(res));
	}
}
