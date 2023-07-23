import java.util.Random;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入:");
        int i = sc.nextInt();
    
        Random r = new Random();
        int randNum = r.nextInt(100); //表示生成0~99范围的随机数
        
        System.out.print("与一个随机数 "+ randNum +" 相加:");
        System.out.println(i+randNum);
    }
}