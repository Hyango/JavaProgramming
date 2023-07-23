package leetcode.topinterviewquestions;

import java.util.Arrays;

public class _Solution_204 {
	public int countPrimes(int n) {
		// 找素数, 高效实现
		// 时间复杂度: O(N * loglogN)
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		
		for (int i = 2; i * i < n; i++)
			if (isPrime[i]) // i 的倍数不可能是素数了
				for (int j = i * i; j < n; j += i)
					// i = 5 时算法会标记 5 × 2 = 10，5 × 3 = 15 等等数字，
					// 但是这两个数字已经被 i = 2 和 i = 3 的 2 × 5 和 3 × 5 标记了
					// 因此 j 从 i * i 开始
					isPrime[j] = false;
		
		int count = 0;
		for (int i = 2; i < n; i++)
			if (isPrime[i]) count++;
		
		return count;
	}
	
	public static void main(String[] args) {
	
	
	}
}
