package leetcode.topinterviewquestions;

import java.util.Arrays;

public class Solution_179 {
	public String largestNumber(int[] nums) {
		// 思路很巧妙
		// 贪心解法
		// 对于 nums 中的任意两个值a和b，我们无法直接从常规角度上确定其大小/先后关系。
		// 但我们可以根据「结果」来决定a和b的排序关系：
		// 如果拼接结果 ab 要比 ba 好，那么我们会认为a应该放在b前面。
		// 另外，注意我们需要处理前导零（最多保留一位）
		
		int length = nums.length;
		String[] ss = new String[length];
		for (int i = 0; i < length; i++) {
			ss[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(ss, (a, b) -> {
			String ab = a + b, ba = b + a;
			return ba.compareTo(ab);
		});
		
		StringBuilder sb = new StringBuilder();
		for (String s : ss) {
			sb.append(s);
		}
		int len = sb.length();
		int k = 0;
		while (k < len - 1 && sb.charAt(k) == '0') k++; // 针对[0, 0, 0]这样的用例
		return sb.substring(k);
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(new Solution_179().largestNumber(nums));
	}
}
