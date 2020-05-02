// 方法一：带备忘录的递归(剪枝)
class Solution {
    public int fib(int N) {
        int[] memo = new int[N + 1];
        return helper(memo, N);
    }

    private int helper(int[] memo, int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        // 已经计算过的值，直接返回(剪枝)
        if (memo[N] != 0) {
            return memo[N];
        }
        memo[N] = helper(memo, N - 1) + helper(memo, N - 2);
        return memo[N];
    }
}


// 方法二：DP数组
class Solution {
    public int fib(int N) {
        if (N <= 0) return -1;
        if (N <= 2) return 1;

        // Base Case
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
}