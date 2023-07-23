package acmexercise.huawei;

import java.util.Scanner;

public class Main_17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String location = in.nextLine();
            String[] splits = location.split(";");
            int[] direction = new int[2];
            for (String split : splits) {
                if (!split.matches("[A-Z][0-9]{1,2}"))
                    continue;
                if (split.charAt(0) == 'A') // 左移
                    direction[0] -= Integer.parseInt(split.substring(1));
                else if (split.charAt(0) == 'D') // 右移
                    direction[0] += Integer.parseInt(split.substring(1));
                else if (split.charAt(0) == 'W') // 上移
                    direction[1] += Integer.parseInt(split.substring(1));
                else if (split.charAt(0) == 'S') // 下移
                    direction[1] -= Integer.parseInt(split.substring(1));
            }
            System.out.println(direction[0] + "," + direction[1]);
        }
    }
}
