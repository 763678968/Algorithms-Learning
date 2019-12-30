class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int left = 1, right = n;
        for (int i = 0; i < n; i++) {
            // 将数组开头和末尾元素按照奇偶规律，交替插入res中
            res[i] = k%2 != 0 ? right-- : left++;
            // k > 1为结束交替的条件，例如：n = 9，k = 5
            // 则前k - 1 = 4个元素间隔需要保持不同，其余的元素保持升序排列即可
            // 如：[1,2,3,4,5,6,7,8,9] → [1, 9, 2, 8, 3, 4, 5, 6, 7]
            // [1, 9, 2, 8, 3]的间隔分别为[8, 7, 6, 5]，有4种间隔，此时k = 1，剩余元素升序排列
            // 间隔全部为1，因此4 + 1 = 5 = k
            if (k > 1) k--;
        }
        return res;
    }
}