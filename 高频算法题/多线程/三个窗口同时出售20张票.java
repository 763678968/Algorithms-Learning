public class Solution {
    public static void main(String[] args) {
        Thread station1 = new Station("窗口1");
        Thread station2 = new Station("窗口2");
        Thread station3 = new Station("窗口3");

        station1.start();
        station2.start();
        station3.start();
    }
}

class Station extends Thread {
    // 给线程名字赋值
    public Station(String name) {
        super(name);
    }

    // 将票数定义为静态变量，这样可以保持在不同线程中的一致性
    static int ticket = 20;

    @Override
    public void run() {
        while (ticket > 0) {
            synchronized (Station.class) {
                if (ticket > 0) {
                    System.out.println(currentThread().getName() + "卖出了第" + ticket + "张票");
                    ticket--;
                } else {
                    System.out.println("票卖光了");
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}