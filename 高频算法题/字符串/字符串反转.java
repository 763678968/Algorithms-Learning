// 程序员代码面试指南P267
// 将how are you 变成 you are how，要求额外空间复杂度为O(1)
class Solution {
    public String rotateWord(String str) {
        if (str == null || str.length() == 0) return "";
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        // 为单词左边界、右边界设置初值-1
        int left = -1, right = -1;
        for (int i = 0; i < chars.length; i++) {
            // 查找翻转每个单词的左右边界
            if (chars[i] != ' ') { // 排除多个连续空格的情况
                // i为整个字符数组的开头(i == 0)或结尾(i == chars.length - 1),
                // 或者每个单词的开头(i - 1)或结尾(i + 1)时，分别在开头处设置left，结尾处设置right
                left = i == 0 || chars[i - 1] == ' ' ? i : left;
                right = i == chars.length - 1 || chars[i + 1] == ' ' ? i : right;
            }
            // 当left、right都不为初值时（也就是找到了一个完整的单词时），翻转单词
            if (left != -1 && right != -1) {
                reverse(chars, left, right);
                // 翻转之后将left、right重新置为默认值-1
                left = -1;
                right = -1;
            }
        }
        return String.valueOf(chars);
    }

    // 使用双指针反转字符串
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++; end--;
        }
    }

    // 也可以使用StringBuilder实现整个字符串的反转
    // 但这种反转的空间复杂度为O(n)
    public static String reverseString(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}


// LeetCode 151. 翻转字符串里的单词
// 字符串首尾可能有空格，单词中间也可能有多个连续的空格
class Solution {
    public String reverseWords(String s) {
        // \s为正则表达式，代表任意类型的空格（例如，空格、tab、换行）
        // 因为java中转义字符本身是用\...来表示的，因此要表示\s，需要两个\\符号
        // +意味着匹配一个或更多个，所以\\s+代表匹配一个或更多个空格
        String[] parts = s.trim().split("\\s+");
        String result = "";
        // 这里i的范围到>0为止，因为下面要对parts[0]单独处理
        for (int i = parts.length - 1; i > 0; i--) {
            result += parts[i] + " ";
        }
        // 在这里单独加上parts[0]，因为如果在上面的for循环中加上parts[0]
        // 则字符串的末尾会带有一个" "，所以在这里单独处理
        return result + parts[0];
    }
}

