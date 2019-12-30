class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        // 首先计算元素数量是否相同，如果不相同，就输出原矩阵
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) return nums;
        int[][] res = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = nums[index / col][index % col];
                index++;
            }
        }
        return res;
    }
}