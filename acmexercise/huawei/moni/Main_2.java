package acmexercise.huawei.moni;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_2 {
	public static void main(String[] args) {
		Map<Character, Character> map = new HashMap<>();
		map.put('a', 'A');
		map.put('e', 'E');
		map.put('i', 'I');
		map.put('o', 'O');
		map.put('u', 'U');
		map.put('A', 'A');
		map.put('E', 'E');
		map.put('I', 'I');
		map.put('O', 'O');
		map.put('U', 'U');
		map.put(' ', ' ');
		Scanner in = new Scanner(System.in);
		// 注意 hasNext 和 hasNextLine 的区别
		while (in.hasNext()) { // 注意 while 处理多个 case
			String s = in.nextLine();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (map.containsKey(c)) sb.append(map.get(c));
				else sb.append(Character.toLowerCase(c));
			}
			System.out.println(sb.toString());
		}
	}
}
