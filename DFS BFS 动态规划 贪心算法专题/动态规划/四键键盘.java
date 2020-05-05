// LeetCode 651.4键键盘
class Solution {
    public static int maxA(int N) {
        // 表示i次操作之后最多能显示多少个A
        int[] dp = new int[N + 1];
        // Base Case
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            // 按下A键
            dp[i] = dp[i - 1] + 1;
            // j是Ctrl-V的起点，因为是状态转移方程，求的是
            // 当前状态与上一个状态之间的关系，所以j < i，不带等号
            for (int j = 2; j < i; j++) {
                // 去除全选(Ctrl-A)、复制(Ctrl-C) 2个操作，连续粘贴 i - j 次
                // 屏幕上一共 dp[i - 2] * (i - j + 1) 个 A
                // 其中j变量减2是给Ctrl-A、Ctrl-C留下操作数
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        // N次按键后最多有几个A？
        return dp[N];
    }
}