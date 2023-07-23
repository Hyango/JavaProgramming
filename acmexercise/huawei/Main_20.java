package acmexercise.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String secret = in.nextLine();
            // 条件1:长度超过8
            if (secret.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            
            // 条件2:包含至少3种类型字符
            int[] type = new int[4];
            int typeNum = 0;
            for (int i = 0; i < secret.length(); i++) {
                char ch = secret.charAt(i);
                if (ch >= 'A' && ch <= 'Z')
                    type[0] = 1;
                else if (ch >= 'a' && ch <= 'z')
                    type[1] = 1;
                else if (ch >= '0' && ch <= '9')
                    type[2] = 1;
                else type[3] = 1;
            }
            for (int i : type) {
                typeNum += i;
            }
            if (typeNum < 3) {
                System.out.println("NG");
                continue;
            }
            
            // 条件3:长度大于2的子串不能重复出现
            int flag = 0;
            Set<String> set = new HashSet<>();
            while (flag <= secret.length() - 3) {
                String substring = secret.substring(flag, flag + 3);
                if (set.contains(substring)) {
                    System.out.println("NG");
                    break;
                }
                set.add(substring);
                flag++;
            }
            
            // 满足所有条件
            if (flag > secret.length() - 3)
                System.out.println("OK");
        }
    }
}
