package leetcode.topinterviewquestions;

public class Solution_14 {
	public String longestCommonPrefix(String[] strs) {
		// 从前往后依次比较,sb记录每次比较后的最长公共前缀,一定是不变或者缩短的.
		StringBuilder sb = new StringBuilder();
		sb.append(strs[0]);
		for (int i = 1; i < strs.length; i++) {
			String s = strs[i];
			while (s.indexOf(sb.toString(), 0) != 0) { // 若sb不是s的前缀,则不断缩短sb
				sb.deleteCharAt(sb.length() - 1);
			}
			if (sb.length() == 0) { // 不存在公共前缀
				break;
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String[] strs = {"dog", "racecar", "car"};
		System.out.println(new Solution_14().longestCommonPrefix(strs));
		
	}
}
