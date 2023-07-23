package acmexercise.huawei;

import java.util.Scanner;

public class Main_84 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// 注意 hasNext 和 hasNextLine 的区别
		while (in.hasNext()) { // 注意 while 处理多个 case
			String str = in.nextLine();
			str = str.replaceAll("[^A-Z]", "");
			System.out.println(str.length());
			
		}
	}
}
