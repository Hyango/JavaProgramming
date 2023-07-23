package leetcode.topinterviewquestions;

public class Solution_38 {
	public String countAndSay(int n) {
		if (n == 1) return "1";
		StringBuilder sb = new StringBuilder("1");
		for (int i = 2; i <= n; i++) {
			String preRes = new String(sb);
			sb.delete(0, sb.length());
			int count = 1;
			for (int j = 0; j < preRes.length(); j++) {
				// 需要写sb的情况: 1.指向最后一个数字时 2.当前数字和下一个数字不一样了
				if (j == preRes.length() - 1 || preRes.charAt(j) != preRes.charAt(j + 1)) {
					sb.append(count);
					sb.append(preRes.charAt(j));
					count = 1;
				} else if (preRes.charAt(j) == preRes.charAt(j + 1)) { // 下一个字符相同
					count++;
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int n = 3;
		System.out.println(new Solution_38().countAndSay(n));
		
	}
}
