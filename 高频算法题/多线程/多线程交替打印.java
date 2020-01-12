// 方法一：锁实现【推荐方法】
class printABCWithLock {
    private int times; // 控制打印次数
    private int state; // 当前状态值：保证三个线程之间交替打印
    private Lock lock = new ReentrantLock(); // 保证每次只有一个线程能够拿到资源

    public printABCWithLock(int times) {
        this.times = times;
    }

    public void printA(){
        print("A", 0);
    }

    public void printB(){
        print("B", 1);
    }

    public void printC(){
        print("C", 2);
    }

    private void print(String name, int targetState) {
        for (int i = 0; i < times; ) {
            lock.lock();
            // 控制交替打印
            if (state % 3 == targetState) {
                state++;
                i++;
                System.out.println("线程：" + name + " 第" + i + "次打印");
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        printABCWithLock printABC = new printABCWithLock(10);
        new Thread(printABC::printA).start();
        new Thread(printABC::printB).start();
        new Thread(printABC::printC).start();
    }
}


// 方法二：信号量semaphore实现【推荐】
class printABCWithSemaphore {
    private int times;
    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);

    public printABCWithSemaphore(int times) {
        this.times = times;
    }

    public void printA() {
        try {
            print("A", semaphoreA, semaphoreB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printB() {
        try {
            print("B", semaphoreB, semaphoreC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printC() {
        try {
            print("C", semaphoreC, semaphoreA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void print(String name, Semaphore current, Semaphore next) throws InterruptedException {
        for (int i = 1; i <= times; i++) {
            current.acquire();
            System.out.println("线程：" + name + " 第" + i + "次打印");
            next.release();
        }
    }

    public static void main(String[] args) {
        printABCWithSemaphore printABC = new printABCWithSemaphore(10);
        new Thread(printABC::printA).start();
        new Thread(printABC::printB).start();
        new Thread(printABC::printC).start();
    }
}


// 方法三：wait / notify实现
class ThreadTest implements Runnable {

    int i = 1;

    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);

        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");

        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        while (true) {
            synchronized(this) {
                // 先唤醒另外一个线程
                notify();
                try {
                    Thread.currentThread();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                    try {
                        // 打印完之后，释放资源，等待下次被唤醒
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


// 方法四：使用Lock / Condition实现
class printABCWithLockCondition {
    private int times;
    private int state;
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    public printABCWithLockCondition(int times) {
        this.times = times;
    }

    public void printA() {
        print("A", 0, conditionA, conditionB);
    }

    public void printB() {
        print("B", 1, conditionB, conditionC);
    }

    public void printC() {
        print("C", 2, conditionC, conditionA);
    }

    private void print(String name, int targetState, Condition current, Condition next) {
        for (int i = 0; i < times; ) {
            lock.lock();
            try {
                while (state % 3 != targetState) {
                    // 当前线程等待
                    current.await();
                }
                state++;
                i++;
                System.out.println("线程：" + name + " 第" + i + "次打印");
                // 通知下一个线程
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        printABCWithLockCondition printABC = new printABCWithLockCondition(10);
        new Thread(printABC::printA).start();
        new Thread(printABC::printB).start();
        new Thread(printABC::printC).start();
    }
}
