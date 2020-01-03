// Manacher算法
class Solution {
    public static int longestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        // 把字符串处理为manacher类字符串，1221 -> #1#2#2#1#
        char[] chars = manacherString(str);
        int[] p = new int[chars.length]; // 回文半径数组

        int max = -1; // max代表以id为中心的最长回文的右边界
        int id = -1; // id代表取得max时的回文中心
        int maxLength = -1; // 最长回文子串长度

        // 遍历每一个字符，计算以该字符为中心的回文字符串长度
        for (int i = 0; i < chars.length; i++) {
            if (i < max) {
                p[i] = Math.min(p[2 * id - i], max - i); // 2*id-i代表i关于id对称的点
            } else {
                p[i] = 1;
            }

            // 从可能扩得更远的位置开始验证
            while (i + p[i] < chars.length && i - p[i] > -1) {
                if (chars[i + p[i]] == chars[i - p[i]]) {
                    p[i]++; // 回文半径增大
                } else {
                    break; // 已经得到该位置的回文半径了
                }
            }

            // 每走一步i，都需要和max进行比较，我们希望 mx 尽可能的远，这样才能更有机会执行 if (i < mx)这句代码，从而提高效率
            if (max < i + p[i]) {
                id = i;
                max = i + p[i];
            }
            maxLength = Math.max(maxLength, p[i]);
        }
        // 返回最大回文字符串长度，因为我们的chars是改造过的，是原字符串的 2倍+1
        // 从中心开始，每个字符后面有一个#，即相当于*2，但中心字符只有一个，所以要-1
        return maxLength - 1;
    }

    private static char[] manacherString(String str) {
        char[] chars = str.toCharArray();
        char[] res = new char[chars.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "abcdcba";
        String str2 = "abcdccba";
        System.out.println(longestPalindrome(str1));
    }
}