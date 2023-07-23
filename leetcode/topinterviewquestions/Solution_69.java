package leetcode.topinterviewquestions;

public class Solution_69 {
	public int mySqrt(int x) {
		// right和left的更新使用mid, 可以确保最终结果一定在[left, right]区间
		if (x == 1) return 1;
		int left = 0, right = x;
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (x / mid == mid) {  // x / mid 为了防溢出
				return mid;
			} else if (x / mid < mid) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		int x = 0;
		System.out.println(new Solution_69().mySqrt(x));
		
	}
}
