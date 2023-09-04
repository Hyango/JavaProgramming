package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_412 {
	
	public List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			if (i % 3 == 0) {
				sb.append("Fizz");
			}
			if (i % 5 == 0) {
				sb.append("Buzz");
			}
			if (sb.length() == 0) {
				sb.append(i);
			}
			result.add(sb.toString());
		}
		return result;
	}
	
	public static void main(String[] args) {
		int n=5;
		System.out.println(new Solution_412().fizzBuzz(n));
	}
}
