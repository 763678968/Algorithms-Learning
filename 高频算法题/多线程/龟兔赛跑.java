public class Solution {
    public static void main(String[] args) {
        Tortoise tortoise = new Tortoise();
        Rabbit rabbit = new Rabbit();

        // 回调方法的使用，谁先调用Calltoback方法，另一个就不跑了
        LetOneStop letOneStop1 = new LetOneStop(tortoise);
        // 让兔子的回调方法里面存在乌龟对象的值，可以把乌龟stop
        rabbit.calltoback = letOneStop1;
        LetOneStop letOneStop2 = new LetOneStop(rabbit);
        // 让乌龟的回调方法里面存在了兔子对象的值，可以把兔子stop
        tortoise.calltoback = letOneStop2;
        tortoise.start();
        rabbit.start();
    }
}

abstract class Animal extends Thread {
    // 跑道长度
    public int length = 2000;

    @Override
    public void run() {
        super.run();
        while (length > 0) {
            running();
        }
    }

    public abstract void running();

    // 在需要回调数据的地方（两个子类需要），声明一个接口
    public static interface Calltoback {
        public void win();
    }

    // 创建接口对象
    public Calltoback calltoback;
}


class Rabbit extends Animal {

    public Rabbit() {
        setName("兔子");
    }

    @Override
    public void running() {
        // 兔子速度
        int dis = 5;
        length -= dis;

        System.out.println("兔子跑了" + dis + "米，距离终点还有" + length + "米");
        if (length <= 0) {
            length = 0;
            System.out.println("兔子获得了胜利");
            // 给回调对象赋值，让乌龟不要再跑了
            if (calltoback != null) {
                calltoback.win();
            }
        }

        try {
            if ((2000 - length) % 20 == 0) {
                sleep(1000);
            } else {
                sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Tortoise extends Animal {
    public Tortoise() {
        setName("乌龟");
    }

    @Override
    public void running() {
        // 乌龟速度
        int dis = 2;
        length -= dis;
        System.out.println("乌龟跑了" + dis + "米，距离终点还有" + length + "米");
        if (length <= 0) {
            length = 0;
            System.out.println("乌龟获得了胜利");
            // 让兔子不再跑了
            if (calltoback != null) {
                calltoback.win();
            }
        }
        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


// 创建一个让动物线程停止的类，这里要实现回调接口
class LetOneStop implements Animal.Calltoback {
    // 动物对象
    Animal animal;

    // 获取动物对象，可以传入兔子或乌龟的实例
    public LetOneStop(Animal animal) {
        this.animal = animal;
    }

    // 让动物的线程停止
    @Override
    public void win() {
        animal.stop();
    }
}