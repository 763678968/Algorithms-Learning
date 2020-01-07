// 从左向右旋转
class Solution {
    public static String reverseString(String str, int m) {
        char[] chars = str.toCharArray();
        // 先反转前半部分
        reverse(chars, 0, m - 1);
        // 再反转后半部分
        reverse(chars, m, chars.length - 1);
        // 最后反转整个数组
        reverse(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    // 双指针反转字符数组
    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++; right--;
        }
    }

    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(reverseString(str, 4));
    }
}