class Solution {
    public int longestValidParentheses(String s) {
        char[] S = s.toCharArray();
        // V[i]用于存储子串的长度
        int[] V = new int[s.length()];
        // 左括号个数open
        int open = 0;
        // 最长子串长度max
        int max = 0;
        for (int i = 0; i < S.length; i++) {
            if (S[i] == '(')
                open++;
            if (S[i] == ')' && open > 0) {
                // 与前一位括号组成一对，子串长度+2
                V[i] = 2 + V[i-1];
                // 将之前的有效子串长度累加
                if (i - V[i] > 0)
                    V[i] += V[i-V[i]];
                open--;
            }
            if (V[i] > max)
                max = V[i];
        }
        return max;
    }
}
