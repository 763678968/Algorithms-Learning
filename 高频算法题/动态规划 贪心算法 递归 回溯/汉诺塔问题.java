class Solution {
    /**
     * 汉诺塔的移动方法
     * @param num 盘子数量
     * @param a 起始塔
     * @param b 中介塔
     * @param c 目标塔
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        // 如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从 " + a + " -> " + c);
        } else {
            // 如果我们有 n >= 2 的情况，我们总是可以看作是两个盘1.最下边的一个盘，2.上面的所有盘
            // 1.先把最上面的所有盘A->B，移动过程会使用到C塔
            hanoiTower(num - 1, a, c, b);
            // 2.把最下面的盘A->C
            System.out.println("第" + num + "个盘从 " + a + " -> " + c);
            // 3.把B塔的所有盘从B->C，移动过程会使用到A塔
            hanoiTower(num - 1, b, a, c);
        }
    }

    public static void main(String[] args) {
        hanoiTower(10, 'A', 'B', 'C');
    }
}