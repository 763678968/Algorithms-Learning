class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return false;
        // 只有一行、一列的情况下，满足托普利茨矩阵条件
        if (matrix.length == 1 || matrix[0].length == 1) return true;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == matrix[i - 1][j - 1])
                    continue;
                else
                    return false;
            }
        }
        return true;
    }
}

// 简化版，不需要引入其他变量，不需要单独判断边界条件
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
            }
        }
        return true;
    }
}