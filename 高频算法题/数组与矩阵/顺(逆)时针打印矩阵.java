// 顺时针打印矩阵
// 无论顺时针还是逆时针打印，只剩一行时，都是从左向右打印；只剩一列时，都是从上向下打印
class Solution {
    public static void printMatrix(int[][] matrix) {
        // 将矩阵看做一圈一圈套在一起，每次打印完外圈，再打印内圈
        // 定义每次要打印的一圈矩阵的左上角横纵坐标和右下角横纵坐标
        int lr = 0; // 左上角的横坐标
        int lc = 0; // 左上角的纵坐标
        int rr = matrix.length - 1; // 右下角的横坐标
        int rc = matrix[0].length - 1; // 右下角的纵坐标

        // 左上角的横纵坐标大于右下角的横纵坐标时，停止打印
        while (lr <= rr && lc <= rc) {
            print(matrix, lr++, lc++, rr--, rc--);
        }
    }

    public static void print(int[][] matrix, int lr, int lc, int rr, int rc) {
        if (lr == rr) { // 矩阵的左上角和右下角横坐标相等，表明只打印一行
            for (int i = lc; i <= rc; i++) {
                System.out.println(matrix[lr][i]);
            }
        } else if (lc == rc) { // 矩阵的左上角和右下角纵坐标相等，表明只打印一列
            for (int i = lr; i <= rr; i++) {
                System.out.println(matrix[i][lc]);
            }
        } else { // 一般情况，打印一圈矩阵
            int curRow = lr;
            int curCol = lc;
            while (curCol != rc) { // 从左向右，打印顶部一行
                System.out.println(matrix[lr][curCol]);
                curCol++;
            }
            while (curRow != rr) { // 从上向下，打印右侧一列
                System.out.println(matrix[curRow][rc]);
                curRow++;
            }
            while (curCol != lc) { // 从右向左，打印底部一行
                System.out.println(matrix[rr][curCol]);
                curCol--;
            }
            while (curRow != lr) { // 从下向上，打印左侧一列
                System.out.println(matrix[curRow][lc]);
                curRow--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(a);
    }
}

// 逆时针打印矩阵
class Solution {
    public static void printMatrix(int[][] matrix) {
        // 将矩阵看做一圈一圈套在一起，每次打印完外圈，再打印内圈
        // 定义每次要打印的一圈矩阵的左上角横纵坐标和右下角横纵坐标
        int lr = 0; // 左上角的横坐标
        int lc = 0; // 左上角的纵坐标
        int rr = matrix.length - 1; // 右下角的横坐标
        int rc = matrix[0].length - 1; // 右下角的纵坐标

        // 左上角的横纵坐标大于右下角的横纵坐标时，停止打印
        while (lr <= rr && lc <= rc) {
            print(matrix, lr++, lc++, rr--, rc--);
        }
    }

    public static void print(int[][] matrix, int lr, int lc, int rr, int rc) {
        if (lr == rr) { // 矩阵的左上角和右下角横坐标相等，表明只打印一行
            for (int i = lc; i <= rc; i++) {
                System.out.println(matrix[lr][i]);
            }
        } else if (lc == rc) { // 矩阵的左上角和右下角纵坐标相等，表明只打印一列
            for (int i = lr; i <= rr; i++) {
                System.out.println(matrix[i][lc]);
            }
        } else { // 一般情况，打印一圈矩阵
            int curRow = lr;
            int curCol = lc;
            while (curRow != rr) { // 从上向下，打印左侧一列
                System.out.println(matrix[curRow][lc]);
                curRow++;
            }
            while (curCol != rc) { // 从左向右，打印底部一行
                System.out.println(matrix[rr][curCol]);
                curCol++;
            }
            while (curRow != lr) { // 从下向上，打印右侧一列
                System.out.println(matrix[curRow][rc]);
                curRow--;
            }
            while (curCol != lc) { // 从右向左，打印顶部一行
                System.out.println(matrix[lr][curCol]);
                curCol--;
            }
        }
    }
}


// LeetCode 54.螺旋矩阵
class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int lr = 0;
        int lc = 0;
        int rr = matrix.length - 1;
        int rc = matrix[0].length - 1;

        while (lr <= rr && lc <= rc) {
            printMatrix(matrix, lr++, lc++, rr--, rc--);
        }

        return result;
    }

    public void printMatrix(int[][] matrix, int lr, int lc, int rr, int rc) {
        if (lr == rr) {
            for (int i = lc; i <= rc; i++) {
                result.add(matrix[lr][i]);
            }
        } else if (lc == rc) {
            for (int i = lr; i <= rr; i++) {
                result.add(matrix[i][lc]);
            }
        } else {
            int curRow = lr;
            int curCol = lc;
            while (curCol != rc) {
                result.add(matrix[lr][curCol]);
                curCol++;
            }
            while (curRow != rr) {
                result.add(matrix[curRow][rc]);
                curRow++;
            }
            while (curCol != lc) {
                result.add(matrix[rr][curCol]);
                curCol--;
            }
            while (curRow != lr) {
                result.add(matrix[curRow][lc]);
                curRow--;
            }
        }
    }
}