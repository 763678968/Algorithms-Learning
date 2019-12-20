class Solution {
    int col, row; // 定义两个变量，用来存储grid矩阵的行数和列数

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0; // 判断grid是否为空[]
        col = grid[0].length; // 矩阵的列数
        row = grid.length; // 矩阵的行数
        int count = 0; // 定义count用来存储岛屿的数量

        // 遍历矩阵grid
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') { // 如果有元素'1'，则出现岛屿
                    numIslandsCore(grid, i, j); // 进一步检查该点周围是否存在为'1'的点
                    count++; // 岛屿数量+1
                }
            }
        }
        return count; // 返回岛屿数量
    }

    private void numIslandsCore(char[][] grid, int i, int j) {
        // 当元素下标越过数组边界，或者该点元素不为'1'时，终止
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') return;

        grid[i][j] = '0'; // 遍历过的点记为'0'，防止重复遍历

        // 遍历grid[i][j]点上下左右的每一个邻接点
        numIslandsCore(grid, i + 1, j);
        numIslandsCore(grid, i, j + 1);
        numIslandsCore(grid, i - 1, j);
        numIslandsCore(grid, i, j - 1);
    }
}
