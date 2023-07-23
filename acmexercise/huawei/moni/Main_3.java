package acmexercise.huawei.moni;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// 注意 hasNext 和 hasNextLine 的区别
		while (in.hasNext()) { // 注意 while 处理多个 case
			String s = in.nextLine();
			int total = 1;
			boolean[] chars = new boolean[26];
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				int count = map.getOrDefault(ch, 0);
				map.put(ch, count++);
			}
			for (int i = 0; i < s.length(); i++) {
				total*= map.size();
				
			}
			
		}
	}
}
