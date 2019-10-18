class Solution {
    public void solve(char[][] board) {
        int i, j;
        int row = board.length;
        if (row == 0)
            return;
        int col = board[0].length;
        
        for (i=0; i < row; i++) {
            check(board, i, 0, row, col);
            if (col > 1)
                check (board, i, col-1, row, col);
        }
        for (j=1; j+1 < col; j++) {
            check (board, 0, j, row, col);
            if (row > 1)
                check (board, row-1, j, row, col);
        }
        for (i=0; i <row; i++) 
            for (j=0; j<col; j++) 
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
        for (i=0; i < row; i++)
            for (j=0; j<col; j++)
                if (board[i][j] == '1')
                    board[i][j] = 'O';
    }
    public void check(char[][] temp, int i, int j, int row, int col) {
        if (temp[i][j] == 'O') {
            temp[i][j] = '1';
            if (i >= 1)
                check(temp, i-1, j, row, col);
            if (j >= 1) 
                check(temp, i, j-1, row, col);
            if (i+1 < row)
                check(temp, i+1, j, row, col);
            if (j+1 < col)
                check(temp, i, j+1, row, col);
        }
    }
}
// 评论区关于溢出的解析：https://leetcode.com/problems/surrounded-regions/discuss/41612/A-really-simple-and-readable-C%2B%2B-solutionuff0conly-cost-12ms
