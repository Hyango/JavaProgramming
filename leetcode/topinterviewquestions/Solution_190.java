package leetcode.topinterviewquestions;

public class Solution_190 {
	public int reverseBits(int n) {
		// 分治解法: 官方提供的库函数思想
		// return Integer.reverse(n); // 调用函数
		
		// rev保存结果, 将n从最低位开始往高位移动.
		int rev = 0;
		for (int i = 0; i < 32 && n != 0; ++i) {
			rev |= (n & 1) << (31 - i);
			n >>>= 1;
		}
		return rev;
	}
	
	public static void main(String[] args) {
		int n = -3;
		// System.out.println(Integer.toBinaryString(n));
		System.out.println(new Solution_190().reverseBits(n));
	}
}
