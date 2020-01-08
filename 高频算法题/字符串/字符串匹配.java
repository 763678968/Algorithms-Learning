// 给定一个字符串str，和另一个模式串pattern
// 判断str中是否包含pattern，如果存在，就返回子串
// 第一次出现的位置，如果不存在，就返回-1
class Solution {
    public static int kmpSearch(String str, String pattern) {
        int[] next = kmpNext(pattern);

        for (int i = 0, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] kmpNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = next[j - 1];
            }
            if (pattern.charAt(j) == pattern.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}



// 变形题：给定一个字符串集合，然后输入一个查询串问查询串
// 是否可以由这个字符串集合的某些字符串构成,可以重复使用字符串集合中的字符串