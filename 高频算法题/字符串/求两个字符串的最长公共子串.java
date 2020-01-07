// 暴力法
// 选取两个字符串中较短的一个字符串，从中截取子串，先从最长的子串开始，检查
// 是否被包含于另一个较长的字符串中，然后依次减小子串长度，如果被包含，则立即返回
// 此时就是最大的公共子串长度
class Solution {
    public static String getMaxSubString(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return null;
        }

        // 两者中较长的字符串
        String max = "";
        // 两者中较短的字符串
        String min = "";
        if (s1.length() < s2.length()) {
            max = s2;
            min = s1;
        } else {
            max = s1;
            min = s2;
        }

        String curStr = "";
        // 遍历较短的字符串，并依次减少从中截取的子串的长度，判断长字符串是否包含短字符串的子串
        for (int i = 0; i < min.length(); i++) {
            // 先遍历短字符串的最长的子串，依次减少，这样只要找到包含在长字符串中就直接返回了
            // 下面的for循环中每次遍历的都是长度相等的字符串，begin和end同时++
            for (int begin = 0, end = min.length() - i; end <= min.length(); begin++, end++) {
                curStr = min.substring(begin, end);
                if (max.contains(curStr)) {
                    return curStr;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s2 = "adefgwgeweg";
        System.out.println(getMaxSubString(s1, s2));
    }
}


// 动态规划
class Solution {
    public static String getMaxSubString(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return null;
        }

        int len1 = s1.length();
        int len2 = s2.length();
        // 记录最长公共子串的长度
        int maxLen = 0;
        // 记录公共子串末尾的元素在矩阵中的下标，可以用记录i，也可以记录j
        // 最后转化到s1或者s2中的下标进行计算即可
        int maxEnd = 0;

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 注意这里的charAt索引为i - 1、j - 1，因为dp矩阵的行数列数比i、j多1
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > maxLen) {
                    // 记录目前的最大子串长度
                    // 如果题目只要求计算最长公共子串的长度，则直接
                    // 返回这个值即可，不需要后面计算子串的操作
                    maxLen = dp[i][j];
                    // 这里选择记录i，即对应于s1中的下标 -1
                    maxEnd = i;
                }
            }
        }
        // substring的计算范围为左闭右开
        return s1.substring(maxEnd - maxLen, maxEnd);
    }

    public static void main(String[] args) {
        String s1 = "acbcbcef";
        String s2 = "abcbced";
        System.out.println(getMaxSubString(s1, s2));
    }
}