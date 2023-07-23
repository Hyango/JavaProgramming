package acmexercise.saike;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = s.length();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (s.startsWith(s.substring(i, j))) {
					sum++;
				} else break;
			}
		}
		System.out.println(sum);
	}
}

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = s.length();
		int[] dp = new int[n];
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			dp[i] = 1; // 每个单独的字符都是满足要求的子字符串
			for (int j = 0; j < i; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i] += dp[j];
				}
			}
			sum += dp[i];
		}
		System.out.println(sum);
	}
}
