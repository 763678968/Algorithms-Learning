// 1.懒汉式-线程不安全
public class Singleton {
    // 定义一个私有静态变量uniqueInstance
    private static Singleton uniqueInstance;

    // 私有化构造方法
    private Singleton() { }

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}

// 2.饿汉式-线程安全
public class Singleton {
    private static Singleton uniqueInstance = new Singleton();

    private Singleton() { }
}

// 3.懒汉式-线程安全
public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() { }

    public static synchronized Singleton getUniqueSingleton() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}

// 4.双重校验锁-线程安全
public class Singleton {
    private static volatile Singleton uniqueInstance;

    private Singleton() { }

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}

// 5.静态内部类实现
public class Singleton {
    private Singleton() { }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }
}

// 6.枚举实现
public enum Singleton {
    INSTANCE;

    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    // 单例测试
    public static void main(String[] args) {
        Singleton firstSingleton = Singleton.INSTANCE;
        firstSingleton.setObjName("firstName");
        System.out.println(firstSingleton.getObjName());
        Singleton secondSingleton = Singleton.INSTANCE;
        secondSingleton.setObjName("secondName");
        System.out.println(firstSingleton.getObjName());
        System.out.println(secondSingleton.getObjName());

        // 反射获取实例测试
        try {
            Singleton[] enumConstants = Singleton.class.getEnumConstants();
            for (Singleton enumConstant : enumConstants) {
                System.out.println(enumConstant.getObjName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}