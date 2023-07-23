package leetcode.topinterviewquestions;

public class Solution_237 {
	public int find(int n) {
		int res = 0;
		while (n != 0) {
			res ^= n % 10;
			n/=10;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution_237().find(182352351));
		
	}
}
