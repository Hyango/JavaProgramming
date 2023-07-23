package TestDemo.VolatileDemo;

public class MyThread2 extends Thread {
    @Override
    public void run() {
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        
        Money.money = 90000;
        System.out.println(Thread.currentThread().getName() + " 修改金额为: " + Money.money);
        
    }
}
