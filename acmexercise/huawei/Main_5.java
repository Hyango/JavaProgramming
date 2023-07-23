package acmexercise.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            str = str.substring(2);
            int length = str.length();
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += map.get(str.charAt(i)) * Math.pow(16, length - i - 1);
            }
            System.out.println(sum);
        }
    }
}
