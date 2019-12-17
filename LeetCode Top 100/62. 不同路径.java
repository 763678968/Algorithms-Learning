// 基础写法
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

// 升级做法，只操作两行，减少内存消耗
class Solution {
    public int uniquePaths(int m, int n) {
        /**
         * 升级做法：因为每次只需要求左侧一格和上面一格的路径总数，所以将问题转化为只对选定点所在行，
         * 以及上一行这两行内进行操作，这样可以将内存消耗减少至O(n)级别
         */
        int[] cur = new int[n];
        int[] pre = new int[n];

        for (int i = 0; i < n; i++) {
            pre[i] = 1;
            cur[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) 
                cur[j] = cur[j - 1] + pre[j];
            // 更新当前行为下一轮循环的上一行
            pre = cur;
        }
        return cur[n - 1];
    }
}

// 再次简化
class Solution {
    public int uniquePaths(int m, int n) {
        /**
         * 进一步地，因为第二种做法中，更新后的pre就是上一轮的cur，
         * 因此可以再次简化为只对一行进行操作
         */
        int[] cur = new int[n];

        for (int i = 0; i < n; i++) {
            cur[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] = cur[j - 1] + cur[j];
            }
        }
        return cur[n - 1];
    }
}
