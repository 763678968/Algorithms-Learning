// LeetCode 877.石子游戏
// 变形为：任意堆数、任意总数的石子，每次可以从左侧或右侧取一堆，求先手与后手的最后得分之差
class Solution {
    class Pair {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int stoneGame(int[] piles) {
        int n = piles.length;
        // 创建Pair矩阵，Pair中的first、second属性分别为先手、后手所能获得的最高分数
        // 例如dp[1][3].first，代表对于piles[1,2,3]这部分石子堆，先手所能获得的最高分数
        Pair[][] dp = new Pair[n][n];
        // 初始化Pair矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }
        // Base Case，对角线上i、j相等，表示只有一堆石子，所以先手得分为piles[i]，后手没有得分
        for (int i = 0; i < n; i++) {
            dp[i][i].first = piles[i];
            dp[i][i].second = 0;
        }
        // 斜着遍历矩阵
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = l + i - 1;
                // 先手选择最左边或者最右边的分数
                int left = piles[i] + dp[i + 1][j].second;
                int right = piles[j] + dp[i][j - 1].second;
                // 状态转移方程，先手从left、right中选取较大值
                if (left > right) {
                    dp[i][j].first = left;
                    dp[i][j].second = dp[i + 1][j].first;
                } else {
                    dp[i][j].first = right;
                    dp[i][j].second = dp[i][j - 1].first;
                }
            }
        }
        Pair res = dp[0][n - 1];
        return res.first - res.second;
    }
}