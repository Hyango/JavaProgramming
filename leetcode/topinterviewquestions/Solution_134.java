package leetcode.topinterviewquestions;

public class Solution_134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		// 参考:https://leetcode.cn/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/
		// 只要总油量-总消耗>=0,那么一定可以跑完一圈
		// 通过画剩余油量图,只要把剩余油量最低点作为起点,那么就可以跑完一圈
		int len = gas.length;
		int totalSpare = 0;
		int minSpare = Integer.MAX_VALUE;
		int minIndex = 0;
		
		for (int i = 0; i < len; i++) {
			totalSpare += gas[i] - cost[i];
			if (totalSpare < minSpare) {
				minSpare = totalSpare;
				minIndex = i;
			}
		}
		return totalSpare < 0 ? -1 : (minIndex + 1) % len;
	}
	
	public int canCompleteCircuit1(int[] gas, int[] cost) {
		// 贪心
		// 参考:https://programmercarl.com/0134.加油站.html
		// 1.首先如果总油量减去总消耗大于等于零那么一定可以跑完一圈，
		// 	 说明各个站点的加油站 剩油量rest[i]相加一定是大于等于零的。
		// 2.i从0开始累加rest[i]，和记为curSum，一旦curSum小于零，说明[0, i]区间都不能作为起始位置，
		// 	 因为这个区间选择任何一个位置作为起点，到i这里都会断油，那么起始位置从i+1算起，再从0计算curSum。
		int curSum = 0;
		int totalSum = 0;
		int index = 0;
		for (int i = 0; i < gas.length; i++) {
			curSum += gas[i] - cost[i];
			totalSum += gas[i] - cost[i];
			if (curSum < 0) {
				index = (i + 1) % gas.length;
				curSum = 0;
			}
		}
		if (totalSum < 0) return -1; // 说明怎么走都不可能跑一圈了
		return index;
	}
	
	public int canCompleteCircuit2(int[] gas, int[] cost) {
		// 暴力解法
		// minus数组的含义: minus[i]表示从 刚到达加油站i -> 刚到达加油站i+1时,油箱的变化量
		// 因此只要满足: 油量oilBox+minus[i]>=0,则可从达到下一个加油站
		// 由于初始油箱为空.因此可进一步推导:
		// 		从某一个minus[i]开始,循环累加到自身,只要保证每一次的结果都为正,则可以回到起点
		int length = gas.length;
		int[] minus = new int[length];
		for (int i = 0; i < length; i++) {
			minus[i] = gas[i] - cost[i];
		}
		
		for (int start = 0; start < length; start++) {
			int oilBox = 0;
			int cur = start;
			do {
				oilBox += minus[cur];
				cur++;
				if (oilBox < 0) break; // 不可到达下一个加油站了,跳出循环
				if (cur == length) cur = 0; /* 更好的方式:cur不断累加,改成取模来遍历cur之前的点 */
			} while (cur != start);
			if (cur == start && oilBox >= 0) return cur; // 证明能够回到起点
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] gas = {2, 3, 4};
		int[] cost = {3, 4, 3};
		System.out.println(new Solution_134().canCompleteCircuit(gas, cost));
	}
}
