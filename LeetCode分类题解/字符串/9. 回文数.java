// 将数字转为字符串（不合题意）
class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}

// 不将数字转为字符串
class Solution {
    public boolean isPalindrome(int x) {
        // 将数字反转，保存到res中，最后比较x与x反转后的res是否相等
        if (x < 0) return false;
        int y = x;
        int res = 0;
        while (y != 0) {
            res = res * 10 + y % 10;
            y /= 10;
        }
        return x == res;
    }
}