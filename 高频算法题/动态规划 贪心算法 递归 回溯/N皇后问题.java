class Solution {
    // 定义一个max表示共有多少个皇后
    int max = 8;
    // 定义数组array，保存皇后放置位置的结果，比如array = {0,4,7,5,2,6,1,3}
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    // 编写一个方法，放置第n个皇后
    // 特别注意：check方法在每一次递归时，进入到check中都有 for (int i = 0; i < max; i++)，因此会有回溯
    private void check(int n) {
        // 例如：八皇后问题中，当n = 8时，8个皇后就已经摆放完成（n是从0开始的）
        if (n == max) {
            print();
            return;
        }

        // 依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇后n，放到该行的第1列
            array[n] = i;
            // 判断当放置第n个皇后到第i列时，是否冲突
            if (judge(n)) { // 如果不冲突
                // 接着放第n + 1个皇后，即开始递归
                check(n + 1);
            }
            // 如果冲突，就继续执行array[n] = i，也就是将第n个皇后，
            // 放置在本行的下一列，继续判断是否冲突
        }
    }

    // 当放置第n个皇后时，就去检测该皇后是否和前面已经摆放的皇后冲突
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // 说明：
            // 1. array[i] == array[n] 表示两个皇后在同一列
            // 2. Math.abs(array[n] - array[i]) == Math.abs(n - i) 表示两个皇后在同一斜线上（也就是y = x）
            // 3. 不需要判断两个皇后是否在同一行，因为n就代表了行，n每次都在递增，不可能在同一行
            if (array[i] == array[n] || Math.abs(array[n] - array[i]) == Math.abs(n - i)) {
                return false;
            }
        }
        return true;
    }

    // 写一个方法，可以将皇后摆放的位置输出
    public void print() {
        count++;
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.check(0);
        System.out.printf("一共有%d种解法\n", count);
        System.out.printf("一共判断冲突的次数：%d", judgeCount);
    }
}