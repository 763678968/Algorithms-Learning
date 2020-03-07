public class Solution {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("thread1 get lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("thread1 get lock2");
                }
            }
            System.out.println("thread1 end");
        });

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println("thread2 get lock2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println("thread2 get lock1");
                    }
                }
                System.out.println("thread2 end");
            }
        };

        thread1.start();
        thread2.start();
    }
}