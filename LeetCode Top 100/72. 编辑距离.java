class Solution {
    public int minDistance(String word1, String word2) {
        int col = word1.length();
        int row = word2.length();

        int[][] dp = new int[row + 1][col + 1];

        for (int i = 0; i <= row; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= col; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (word1.charAt(j - 1) == word2.charAt(i - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[row][col];
    }
}
