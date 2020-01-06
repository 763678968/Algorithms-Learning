// 顺时针旋转
class Solution {
    public static void rotateMatrix(int[][] matrix) {
        // 关于矩阵的中轴线，依次交换上边和下边的行
        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++; end--;
        }
        // 交换关于对角线对称的元素，不包含对角线
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotateMatrix(arr);
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }
}

// 逆时针旋转
class Solution {
    public static void rotateMatrix(int[][] matrix) {
        // 关于矩阵的中轴线，依次交换左侧和右侧的列
        int start = 0;
        int end = matrix[0].length - 1;
        while (start < end) {
            int[] temp = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                temp[i] = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp[i];
            }
            start++; end--;
        }
        // 交换关于对角线对称的元素，不包含对角线
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}