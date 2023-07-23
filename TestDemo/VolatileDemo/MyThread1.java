package TestDemo.VolatileDemo;

public class MyThread1 extends Thread {
    @Override
    public void run() {
        while(Money.money == 100000){
//            System.out.print(1);
        }
        System.out.println();
        System.out.println("结婚基金已经不是十万了");
    }
}
