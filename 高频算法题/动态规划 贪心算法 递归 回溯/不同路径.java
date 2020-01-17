class Solution {
    public int uniquePaths(int m, int n) {
        /**
         * 基础做法，到达网格中任意一点的路径总数等于该点左侧一格和上方一格路径总数之和
         * 当选定的点位于第一列或者第一行时，只有一条路径，为边界条件
         */
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }
}