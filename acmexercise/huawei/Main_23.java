package acmexercise.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main_23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            // 利用map计数
            for (int i = 0; i < str.length(); i++) {
                Integer count = map.getOrDefault(str.charAt(i), 0);
                map.put(str.charAt(i), count + 1);
            }
            // 找到出现次数最少的字符,拼成字符串
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            int minNum = Integer.MAX_VALUE;
            String minChar = "";
            for (Map.Entry<Character, Integer> entry : entries) {
                if (entry.getValue() == minNum) {
                    minChar += entry.getKey();
                } else if (entry.getValue() < minNum) {
                    minNum = entry.getValue();
                    minChar = "" + entry.getKey();
                }
            }
            // 删除出现最少的字符
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (minChar.indexOf(str.charAt(i)) >= 0)
                    continue;
                else sb.append(str.charAt(i));
            }
            System.out.println(sb.toString());
        }
    }
}
