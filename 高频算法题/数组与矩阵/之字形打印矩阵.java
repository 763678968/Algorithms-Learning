class Solution {
    public static void printZigMatrix(int[][] matrix) {
        // 每次打印的轨迹的两个端点：A(a ,b) B(c, d)
        int a = 0, b = 0, c = 0, d = 0;
        // 矩阵右下角的坐标：(matrix.length - 1, matrix[0].length - 1)
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        // 判断每次打印的方向，每打印完一次就需要换方向
        boolean direction = true;

        // A先是往右走，走到最右再往下走；B先是往下走，走到最下再开始往右走
        while (a <= row && b <= col) {
            print(matrix, a, b, c, d, direction);
            direction = !direction; // 打印一次之后就切换方向
            // 如果A走到了最右边，则开始向下走
            // a这行代码要在b的上面
            a = b >= col ? a + 1 : a;
            // b这行代码要在a的下面，因为a的选择表达式中的判断条件为b，
            // 将b放在上面的话，b的值变化之后，会对a的判断条件造成干扰
            b = b < col ? b + 1 : b;

            // 如果B走到了最下边，则开始向右走
            d = c >= row ? d + 1 : d; // d这行代码要在c的上面
            c = c < row ? c + 1 : c; // c这行代码要在d的下面，同理
        }
    }

    // 打印A、B两个点之间的轨迹
    public static void print(int[][] matrix, int a, int b, int c, int d, boolean direction) {
        // direction为true时，从下往上打印，即B -> A
        if (direction) {
            for (; a <= c; c--, d++) {
                System.out.println(matrix[c][d]);
            }
        } else { // direction为false时，从上往下打印，即 A -> B
            for (; a <= c; a++, b--) {
                System.out.println(matrix[a][b]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printZigMatrix(a);
    }
}