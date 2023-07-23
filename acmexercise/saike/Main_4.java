package acmexercise.saike;

// import java.util.*;
//
// public class Main_4 {
// 	private static long count = 0;
// 	public static void main(String[] args) {
// 		Scanner in = new Scanner(System.in);
// 		int n = in.nextInt();
// 		int k = in.nextInt();
// 		for (int i = 0; i < k; i++) {
// 			dfs(n, k, 1, i); // 调用深度优先搜索
// 		}
// 		System.out.println(count); // 输出结果
// 	}
//
// 	private static void dfs(int n, int k, int boxId, int prev) {
// 		if (boxId == n) {
// 			count++;
// 			return;
// 		}
// 		for (int i = 0; i < k; i++) {
// 			if (i != prev) {
// 				dfs(n, k, boxId + 1, i);
// 			}
// 		}
// 	}
// }
import java.util.Scanner;

public class Main_4 {
	static long[][] dp = new long[1005][1005];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		for (int i = 1; i <= k; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				for (int l = 1; l <= k; l++) {
					if (l != j) {
						dp[i][j] += dp[i - 1][l];
					}
				}
			}
		}
		int ans = 0;
		for (int i = 1; i <= k; i++) {
			ans += dp[n][i];
		}
		System.out.println(ans);
	}
}
