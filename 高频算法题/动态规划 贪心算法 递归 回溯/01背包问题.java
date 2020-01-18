class Knapsack {
    /**
     * 01背包问题
     * @param size 物品的体积
     * @param value 物品的价格
     * @param bagSize 背包的容量
     * @param items 背包中最终放入的物品
     */
    private int[] size;
    private int[] value;
    private int[] items;
    private int bagSize;

    public Knapsack(int[] size, int[] value, int bagSize) {
        this.size = size;
        this.value = value;
        this.items = new int[size.length];
        this.bagSize = bagSize;
    }

    public void maxValue() {
        int row = size.length + 1;
        int col = bagSize + 1;
        int[][] dp = new int[row][col];
        // i代表当前遍历到第i个物品
        // 下面size、value中的-1是为了与dp矩阵对齐下标
        for (int i = 1; i < row; i++) {
            // j代表当前背包的容量
            for (int j = 1; j < col; j++) {
                // 如果背包的容量小于物品的体积，则装不下，与装上一个物品的结果相同
                if (j < size[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    // 如果可以装得下当前的物品，则需要判断1.装当前物品和2.不装当前物品哪个价值更高
                } else {
                    // dp[i - 1][j - size[i - 1]]代表装入当前物品之前的状态 value[i - 1]代表当前商品的价值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - size[i - 1]] + value[i - 1]);
                }
            }
        }
        // 打印动态规划表
        System.out.println("动态规划表为：");
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println("\n最大价值为：" + dp[row - 1][col - 1]);

        // 打印装入背包的物品列表
        getItems(dp, row - 1, col - 1);
        System.out.println("\n装入背包的物品有：");
        System.out.println(Arrays.toString(items));
    }

    private void getItems(int[][] dp, int i, int j) {
        if (i > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                items[i - 1] = 0;
                getItems(dp, i - 1, j);
            } else if (j - size[i - 1] >= 0 && dp[i][j] == dp[i - 1][j - size[i - 1]] + value[i - 1]) {
                items[i - 1] = 1;
                getItems(dp, i - 1, j - size[i - 1]);
            }
        }
    }

    public static void main(String[] args) {
        int[] size = {2,3,4,5};
        int[] value = {3,4,5,6};
        int bagSize = 8;
        Knapsack k = new Knapsack(size, value, bagSize);
        k.maxValue();
    }
}