class Solution {
    public int countSubstrings(String s) {
//        if (s.length() == 0) return 0;

        int count = 0;
        for (int i = 0; i < s.length(); i++) { // i代表回文串的中间点
            count += extractPalindrome(s, i, i); // 提取奇数长度回文串
            count += extractPalindrome(s, i, i + 1); // 提取偶数长度回文串
        }
        return count;
    }

    private int extractPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            // 左右指针分别从中间向两侧移动
            // 偶数长度回文串，两指针一开始不重合；奇数长度回文串，两指针一开始重合
            left--;
            right++;
        }
        return count;
    }
}