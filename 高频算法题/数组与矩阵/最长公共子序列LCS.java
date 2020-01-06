class Solution {
    public static int longestCommonSubsequence(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // 如果两字符串的字符相等，就在上一次的匹配结果基础上 +1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果两字符串的字符不相等，就在当前位置的上方或左侧选取较大值
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}