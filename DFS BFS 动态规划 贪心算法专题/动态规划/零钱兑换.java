// LeetCode 322.零钱兑换
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 将dp数组初始化为amount + 1
        // 因为凑成amount金额的硬币数最多只可能等于amount（全用1元面值的硬币）
        // 所以初始化为amount + 1就相当于初始化为正无穷，便于在之后的内层for循环中求dp[i]的最小值
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                // 在不同面值的硬币的结果中寻找最小值
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        // 如果dp[amount]等于初始值，表明没有可行解，返回-1
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}