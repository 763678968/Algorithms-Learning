import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        
        // 输入的二维数组非法，返回空的数组
        if (row == 0 || col == 0)
            return res;
        
        // 定义四个关键变量，表示左上和右下的打印范围
        int left = 0, top = 0, right = col - 1, bottom = row - 1;
        while (left <= right && top <= bottom) {
            // left to right
            for (int i = left; i <= right; ++i)
                res.add(matrix[top][i]);
            // top to bottom
            for (int i = top + 1; i <= bottom; ++i)
                res.add(matrix[i][right]);
            // right to left 
            if (top != bottom)
                for (int i = right - 1; i >= left; --i)
                    res.add(matrix[bottom][i]);
            // bottom to top
            if (left != right)
                for (int i = bottom - 1; i > top; --i)
                    res.add(matrix[i][left]);
            left++;
            top++;
            right--;
            bottom--;
        }
        return res;
    }
}
