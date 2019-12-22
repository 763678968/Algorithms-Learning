class Solution {
    public int maximalSquare(char[][] matrix) {
        /**
         * 令dp[i][j]代表右下角坐标为(i, j)的正方形的边长
         * 当matrix[i - 1][j - 1]不为0时，dp[i][j]等于它上方、左方、左上方三者中边长的最小值再+1
         * 这是因为当一条边比另一条边短时，就无法构成正方形,而且maxtrix[i - 1][j - 1]为0时，
         * 它右下角的元素一定不能与它构成正方形，所以需要进行matrix[i - 1][j - 1]不为0判断
         */
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int max = 0, row = matrix.length, col = matrix[0].length;
        
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1')
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }
}
