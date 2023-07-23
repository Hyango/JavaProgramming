package leetcode.weekcompetition.competition342;

public class Solution_2 {
	public int sumOfMultiples(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 3; j <= 7; j += 2) {
				if (i%j==0){
					sum+=i;
					break;
				}
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
	
	
	}
}
