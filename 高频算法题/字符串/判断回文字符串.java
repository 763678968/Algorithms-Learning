class Solution {
    public static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        int len = str.length();
        int left = len / 2;
        int right;
        // 判断奇偶回文串
        if (len % 2 != 0) { // 奇数回文，如aba，左右指针的初始位置重合
            right = left;
        } else { // 偶数回文，如abba，右指针的初始位置比左指针靠右一位
            right = left + 1;
        }

        // 双指针，从中间向两边移动对比
        while (left >= 0 && right < len) {
            if (str.charAt(left) == str.charAt(right)) {
                left--; right++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aba";
        System.out.println(isPalindrome(str));
    }
}