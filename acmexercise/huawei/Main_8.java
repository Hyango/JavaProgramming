package acmexercise.huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int index, value;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                index = in.nextInt();
                value = in.nextInt();
                Integer mapValue = map.getOrDefault(index, 0);
                map.put(index, mapValue + value);
            }
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                System.out.print(entry.getKey() + " ");
                System.out.println(entry.getValue());
            }
        }
    }
}
