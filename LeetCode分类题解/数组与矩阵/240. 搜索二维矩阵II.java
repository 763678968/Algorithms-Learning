class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row = 0;
        int col = matrix[0].length - 1;
        // 令初始元素位置在矩阵右上角
        while (row <= matrix.length - 1 && col >= 0) {
            if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}