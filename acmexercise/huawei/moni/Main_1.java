package acmexercise.huawei.moni;

import java.util.Scanner;

public class Main_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// 注意 hasNext 和 hasNextLine 的区别
		while (in.hasNext()) { // 注意 while 处理多个 case
			String s = in.nextLine();
			int totalV = 0;
			int wordCount = 1;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != ' ') {
					totalV++;
				} else wordCount++;
			}
			System.out.printf("%.2f", 1.0 * totalV / wordCount);
		}
	}
}
