// LeetCode 516.最长回文子序列
class Solution {
    // 在字符串两端分别维护一个指针i和指针j，向字符串中间靠拢
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        // 将对角线元素填充为1，表示i == j，即只有一个元素的情况，那么这个元素本身就是回文子序列，长度为1
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        // 从DP矩阵的右下角开始填充
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        // 返回i = 0，j = len - 1时的情况，即对整个字符串所进行的最长回文子序列的计算结果
        return dp[0][len - 1];
    }
}