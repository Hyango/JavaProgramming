package acmexercise.huawei;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_36 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 顺序字母表
        String oriTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        while (in.hasNext()) { // 注意 while 处理多个 case
            String key = in.nextLine();
            String mingWen = in.nextLine();
            key = key.toUpperCase();
            // 去重
            Set<Character> set = new LinkedHashSet<>();
            for (int i = 0; i < key.length(); i++) {
                set.add(key.charAt(i));
            }
            // 新字母表
            StringBuilder newTable = new StringBuilder();
            for (Character character : set) {
                newTable.append(character);
            }
            for (int i = 0; i < oriTable.length(); i++) {
                if (set.contains(oriTable.charAt(i)))
                    continue;
                else newTable.append(oriTable.charAt(i));
            }
            // 加密
            StringBuilder miWen = new StringBuilder();
            for (int i = 0; i < mingWen.length(); i++) {
                char ch = mingWen.charAt(i);
                if (ch >= 'a' && ch <= 'z') {
                    int index = ch - 'a'; // 明文字符对应的newTable的下标
                    char mi = newTable.charAt(index);
                    miWen.append(Character.toLowerCase(mi));
                } else if (ch >= 'A' && ch <= 'Z') {
                    int index = ch - 'A'; // 明文字符对应的newTable的下标
                    char mi = newTable.charAt(index);
                    miWen.append(mi);
                } else miWen.append(ch);// 空格
            }
            System.out.println(miWen.toString());
        }
    }
}
