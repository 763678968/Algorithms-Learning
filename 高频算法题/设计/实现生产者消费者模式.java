// 推荐写法
public class ProducerConsumer {
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    private static class Producer implements Runnable {
        @Override
        public void run() {
            try {
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("produce...");
        }
    }

    private static class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                String product = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("consume...");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer();
            new Thread(producer).start();
        }
        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            new Thread(consumer).start();
        }
        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer();
            new Thread(producer).start();
        }
    }
}


// 1.通过 wait() / notify()实现
// 生产者
class Producer implements Runnable {
    // 为true时，生产者生产，为false时停止生产
    private volatile boolean needProduce = true;
    // 公共资源
    private final ArrayList sharedQueue;
    // 公共资源的最大数量
    private final int SIZE;
    // 生产数据
    private static AtomicInteger count = new AtomicInteger();

    public Producer(ArrayList sharedQueue, int SIZE) {
        this.sharedQueue = sharedQueue;
        this.SIZE = SIZE;
    }

    @Override
    public void run() {
        int data;
        Random random = new Random();

        System.out.println("start producer id = " + Thread.currentThread().getId());
        try {
            while (needProduce) {
                // 模拟延迟
                Thread.sleep(random.nextInt(1000));
                // 当队列已经满了的时候，就阻塞等待
                while (sharedQueue.size() == SIZE) {
                    synchronized (sharedQueue) {
                        System.out.println("Queue is full, producer " + Thread.currentThread().getId() + " is waiting, size: " + sharedQueue.size());
                        sharedQueue.wait();
                    }
                }

                // 阻塞队列不满时就继续生产
                synchronized (sharedQueue) {
                    // 生产数据
                    data = count.incrementAndGet();
                    sharedQueue.add(data);
                    System.out.println("producer create data:" + data + ", size:" + sharedQueue.size());
                    sharedQueue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    // 停止生产
    public void stop() {
        needProduce = false;
    }
}


// 消费者
class Consumer implements Runnable {
    // 公共资源
    private final ArrayList sharedQueue;

    public Consumer(ArrayList sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("start consumer id = " + Thread.currentThread().getId());
        try {
            while (true) {
                // 模拟延迟
                Thread.sleep(1000);
                // 当队列为空时，阻塞等待生产者生产新的数据
                while (sharedQueue.isEmpty()) {
                    synchronized (sharedQueue) {
                        System.out.println("Queue is empty, consumer " + Thread.currentThread().getId() + " is waiting, size: " + sharedQueue.size());
                        sharedQueue.wait();
                    }
                }
                // 队列不为空时，直接消费
                synchronized (sharedQueue) {
                    System.out.println("consumer consume data: " + sharedQueue.remove(0) + ", size: " + sharedQueue.size());
                    sharedQueue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}

class Test {
    public static void main(String[] args) throws InterruptedException {
        // 1.建立内存缓冲区
        ArrayList sharedQueue = new ArrayList();
        int size = 4;

        // 2.构建线程池和线程
        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer1 = new Producer(sharedQueue, size);
        Producer producer2 = new Producer(sharedQueue, size);
        Producer producer3 = new Producer(sharedQueue, size);
        Consumer consumer1 = new Consumer(sharedQueue);
        Consumer consumer2 = new Consumer(sharedQueue);
        Consumer consumer3 = new Consumer(sharedQueue);
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);

        // 3.休息一会，然后尝试停止生产者（结束循环）
        Thread.sleep(10 * 1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();

        // 4.再休息一会，关闭线程池
        Thread.sleep(3000);

        // 5.shutdown()等待任务执行完才中断线程（消费者线程未停止，所以其实程序是无法结束的）
        service.shutdown();
    }
}



// 2.通过阻塞队列实现
class Producer implements Runnable {

    private volatile boolean needProduce = true;
    // 内存缓冲区
    private BlockingQueue<Integer> queue;
    // 总数，原子操作
    private static AtomicInteger count = new AtomicInteger();

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int data;
        Random random = new Random();
        System.out.println("start producer id = " + Thread.currentThread().getId());
        try {
            while (needProduce) {
                // 模拟延迟
                Thread.sleep(random.nextInt(1000));

                // 往阻塞队列中添加数据
                data = count.incrementAndGet();
                System.out.println("producer " + Thread.currentThread().getId() + " create data: " + data + ", size: " + queue.size());
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println("failed to put data:" + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    // 停止生产者线程
    public void stop() {
        needProduce = false;
    }
}


class Consumer implements Runnable {
    // 内存缓冲区
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int data;
        Random random = new Random();
        System.out.println("start consumer id = " + Thread.currentThread().getId());

        try {
            while (true) {
                // 模拟延迟
                Thread.sleep(random.nextInt(1000));

                // 从阻塞队列中消费数据
                if (!queue.isEmpty()) {
                    data = queue.take();
                    System.out.println("consumer " + Thread.currentThread().getId() + "consumer data: " + data + ", size: " + queue.size());
                } else {
                    System.out.println("Queue is empty, consumer " + Thread.currentThread().getId() + " is waiting, size: " + queue.size());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}


class Test {
    public static void main(String[] args) throws InterruptedException {
        // 1.构建内存缓冲区
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        // 2.构建线程池和线程
        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);

        // 3.休息一会，然后尝试停止生产者（结束循环）
        Thread.sleep(10 * 1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();

        // 4.再休息一会，关闭线程池
        Thread.sleep(3000);

        // 5.shutdown() 等待任务执行完才中断线程（消费者线程未停止，所以其实程序是无法结束的）
        service.shutdown();
    }
}