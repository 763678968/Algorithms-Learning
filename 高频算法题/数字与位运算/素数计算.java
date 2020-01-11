// 1.求100以内的全部素数（暴力法）
class Solution {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            if (i == 2) {
                System.out.println(i);
                continue;
            }
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
                if (j == i - 1) {
                    System.out.println(i);
                }
            }
        }
    }
}

// 2.求100以内的全部素数（平方根方法）
class Solution {
    public static void main(String[] args) {
        // 设立一个标记位，false表示为素数
        boolean flag;

        for (int i = 1; i <= 100; i++) {
            flag = false;
            // 2是素数，单独处理
            if (i == 2) {
                System.out.println(i);
                continue;
            }
            // 根据数学规律，只要除到i的平方根即可，不需要一直除到i-1
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    // i能被j整除，表明不是素数，将标记位记为true
                    flag = true;
                    break;
                }
            }
            // 只打印标记位为false的素数
            if (flag == false) {
                System.out.println(i);
            }
        }
    }
}


// 3.求100以内的全部素数（素数筛法）
class Solution {
    public static void main(String[] args) {
        boolean[] isPrime = new boolean[100];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        // 从2开始，将这个数与2的倍数、3的倍数、4的倍数...依次更改为false
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = 2; j * i < isPrime.length; j++) {
                    isPrime[j * i] = false;
                }
            }
        }

        // 最后从isPrime数组中挑选剩余的为true的元素输出
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}


// 4.求101~202之间的所有素数并统计个数
class Solution {
    public static void main(String[] args) {
        boolean flag = false;
        int count = 0;
        for (int i = 101; i <= 202; i++) {
            flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }
}