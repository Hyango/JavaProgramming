package leetcode.topinterviewquestions;

public class Solution_50 {
	public double myPow(double x, int n) {
		double res = 1.0D;
		res = n > 0 ? traverse(x, n) : traverse(x, -n);
		return n > 0 ? res : 1 / res;
	}
	
	private double traverse(double x, int n) {
		if (n == 0) return 1;
		if (n == 1) return x;
		double part = traverse(x, n / 2);
		if (n % 2 == 0) {
			return part * part;
		} else {
			return part * part * x;
		}
	}
	
	public static void main(String[] args) {
		double x = 2.00000;
		int n = -2;
		System.out.println(new Solution_50().myPow(x, n));
	}
}
