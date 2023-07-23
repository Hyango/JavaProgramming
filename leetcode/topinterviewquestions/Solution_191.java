package leetcode.topinterviewquestions;

public class Solution_191 {
	public int hammingWeight(int n) {
		// 调库函数, 分治思想解决
		// return Integer.bitCount(n);
		
		int count = 0;
		for (int i = 0; i < 32; i++) {
			count += ((n >>> i) & 1); // >>> 表示逻辑右移,高位补0
		}
		return count;
	}
	
	public static void main(String[] args) {
		int n = -3;
		System.out.println(new Solution_191().hammingWeight(n));
	}
}
