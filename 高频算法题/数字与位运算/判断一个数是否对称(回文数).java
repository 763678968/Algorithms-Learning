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