// 沿主对角线方向打印矩阵
// 输入一个矩阵，从右上角开始按照主对角线方向打印矩阵的值
class Solution {
    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        int row, col;
        // 输出对角线右上方矩阵及对角线
        for (int i = n - 1; i >= 0; i--) {
            row = 0; col = i; // 每次都是从第0行开始，所以需要令row = 0
            while (row >= 0 && row < n && col >= 0 && col < n) {
                System.out.println(matrix[row][col]);
                row++; col++; // 行、列同时递增
            }
        }
        for (int i = 1; i <= n - 1; i++) { // 对角线已经打印过，所以i从1开始
            row = i;  col = 0; // 每次都是从第0列开始，所以需要令col = 0
            while (row >= 0 && row < n && col >= 0 && col < n) {
                System.out.println(matrix[row][col]);
                row++; col++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(arr);
    }
}

// 沿副对角线打印矩阵
// 输入一个矩阵，从左上角开始按照副对角线方向打印矩阵的值
class Solution {
    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        int row, col;
        for (int i = 0; i < n; i++) {
            row = 0; col = i;
            while (row >= 0 && row < n && col >= 0 && col < n) {
                System.out.println(matrix[row][col]);
                row++; col--;
            }
        }
        for (int i = 1; i <= n - 1; i++) {
            row = i; col = n - 1;
            while (row >= 0 && row < n && col >= 0 && col < n) {
                System.out.println(matrix[row][col]);
                row++; col--;
            }
        }
    }
}
