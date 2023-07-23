package leetcode.topinterviewquestions;

public class Solution_7 {
	public int reverse(int x) {
		boolean negative = false;
		String s;
		StringBuilder sb;
		s = String.valueOf(x);
		if (x >= 0) {
			sb = new StringBuilder(s);
		} else {
			sb = new StringBuilder(s.substring(1, s.length()));
			negative = true;
		}
		sb.reverse();
		if (Long.parseLong(sb.toString()) > Integer.MAX_VALUE || Long.parseLong(sb.toString()) < Integer.MIN_VALUE)
			return 0;
		int res = Integer.parseInt(sb.toString());
		
		return negative == true ? -res : res;
	}
	
	public static void main(String[] args) {
		int x = Integer.MIN_VALUE;
		System.out.println(new Solution_7().reverse(x));
		
	}
}
