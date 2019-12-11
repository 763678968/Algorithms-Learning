class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int palindromeStartsAt = 0, maxLen = 0;

        // 矩阵dp用来判断 下标从i开始到j结束 的子串是否为回文串
        boolean[][] dp = new boolean[n][n];

        // 使用指针i从后向前遍历字符串中的每一个字符
        for (int i = n-1; i >= 0; i--) {
            // 查找窗口[i, j]中的子串是否为回文串
            for (int j = i; j < n; j++) {
                /**
                 * 如果为回文串：
                 * 1. i, j处的字符应该相等；
                 * 2. 且 当窗口长度小于等于3时，首末字符应当相等
                 * 3. 当窗口长度大于3时，[i+1, j-1]范围内的子串也应当是回文串（动态规划）
                 */
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j-i < 3 || dp[i+1][j-1]);

                // 更新目前最大的回文串
                if (dp[i][j] && (j-i+1 > maxLen)) {
                    palindromeStartsAt = i;
                    maxLen = j-i+1;
                }
            }
        }
        return s.substring(palindromeStartsAt, palindromeStartsAt + maxLen);
    }
}
