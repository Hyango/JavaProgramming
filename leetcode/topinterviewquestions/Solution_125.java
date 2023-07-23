package leetcode.topinterviewquestions;

public class Solution_125 {
	public boolean isPalindrome(String s) {
		if (s.equals(" ")) return true;
		StringBuilder sb = new StringBuilder();
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= 'a' && ch <= 'z'||ch >= '0' && ch <= '9')
				sb.append(ch);
		}
		StringBuilder sbRev = new StringBuilder(sb);
		sbRev.reverse();
		return sb.toString().equals(sbRev.toString());
	}
	
	public static void main(String[] args) {
		String s = "0P";//"race a car";//"A man, a plan, a canal: Panama";
		System.out.println(new Solution_125().isPalindrome(s));
		
	}
}
