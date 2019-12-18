class Solution {
    public int minPathSum(int[][] grid) {
        /**
         * 与62.不同路径非常类似
         * 同样对第一行、第一列依次累加即可
         * 其余位置的结果由左侧一格和上方一格决定，取两者中的最小值
         */
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] sum = new int[grid.length][grid[0].length];
        sum[0][0] = grid[0][0];
        
        // 第一列的路径和，将路径上的点依次累加即可
        for (int i = 1; i < row; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }

        // 第一行的路径和，将路径上的点依次累加即可
        for (int i = 1; i < col; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }
        
        // 一般位置的路径和，需要由左侧和上方一格的路径和计算，取两者中的最小值
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        return sum[row - 1][col - 1];
    }
}
