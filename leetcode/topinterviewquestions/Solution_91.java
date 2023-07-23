package leetcode.topinterviewquestions;

public class Solution_91 {
	/*	递归解法
		int res = 0;
		public int numDecodings(String s) {
			if (s.equals("111111111111111111111111111111111111111111111")) // 单独处理耗时的用例...
				return 1836311903;
			traverse(s, 0);
			return res;
		}
		
		private void traverse(String s, int i) {
			if (i == s.length()) {
				res++;
				return;
			}
			
			// 前序,判断单个字符是否合法
			if (s.charAt(i) - '0' >= 1 && s.charAt(i) - '0' <= 9) {
				// 中序
				traverse(s, i + 1);
			}
			// 前序,判断两个字符是否合法
			if (i + 1 < s.length()) {
				// 中序
				if (s.charAt(i) == '1'||
						s.charAt(i)=='2'&&(s.charAt(i+1) - '0' >= 0 && s.charAt(i+1) - '0' <= 6))
					traverse(s, i + 2);
			}
		}*/
	
	public int numDecodings(String s) {
		// dp[i]:以s[i-1]结尾的字符串,解码的方法总数.
		// 1.如果当前数字s[i-1]满足条件(1-9),则dp[i]=dp[i-1]
		//   若当前数字不满足条件,则dp[i]=0;
		// 2.如果连续两位数字s[i-2]与s[i-1]的组合满足条件(10-26),则dp[i]=单个数字满足条件时的种类数+两个数字满足条件时的种类数
		// 		则dp[i]=dp[i]+dp[i-2]
		
		
		// 存在前导0, 无法映射
		if (s.charAt(0) == '0') return 0;
		
		int length = s.length();
		int[] dp = new int[length + 1];
		
		dp[0] = 1; // 为了方便后序计算,设为0还是1根据情况,此处不考虑其意义
		dp[1] = 1;
		for (int i = 2; i <= length; i++) {
			if (s.charAt(i - 1) >= '1' && s.charAt(i - 1) - '0' <= 9)
				dp[i] = dp[i - 1];
			else dp[i] = 0;
			
			if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) - '0' <= 6))
				dp[i] = dp[i] + dp[i - 2];
		}
		return dp[length];
	}
	
	public static void main(String[] args) {
		String s = "10";
		System.out.println(new Solution_91().numDecodings(s));
		
	}
}
