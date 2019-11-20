public int LastRemaining_Solution(int n, int m) {
    if (n<1 || m<1) return -1;
    int[] array = new int[n];
    int i = -1, step = 0, count = n;
    while (count > 0) { // 跳出循环时将最后一个元素也设置为了-1
        i++; // 指向上一个被删除对象的下一个元素
        if (i >= n) i = 0; // 模拟环
        if (array[i] == -1) continue; // 跳过被删除的对象
        step++; // 记录已走过的
        if (step == m) { // 找到待删除的对象
            array[i] = -1;
            step = 0;
            count--;
        }
    }
    return i; // 返回跳出循环时的i，即最后一个被设置为-1的元素
}
