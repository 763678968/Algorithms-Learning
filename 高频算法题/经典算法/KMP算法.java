// KMP算法
class Solution {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpNext("ABCDABD");
        System.out.println("next = " + Arrays.toString(next));

        int index = kmpSearch(str1, str2, next);
        System.out.println("index = " + index);

    }

    /**
     * @param str1 源字符串
     * @param str2 子串
     * @param next 部分匹配表
     * @return 返回-1表示没有匹配到，否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        // 遍历str1
        for (int i = 0, j = 0; i < str1.length(); i++) {
            // 需要处理str1.charAt(i) != str2.charAt(j)，去调整j的大小
            // 相当于使用部分匹配表来更新j的值
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }

            if (j == str2.length()) { // 找到了
                return i - j + 1;
            }
        }
        return -1;
    }

    // 获取到一个字符串（子串）的部分匹配表
    public static int[] kmpNext(String dest) {
        // 创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; // 如果字符串长度为1，不存在前缀、后缀，则部分匹配值为0
        for (int i = 1, j = 0; i < dest.length(); i++) {
            // 当dest.charAt(i) != dest.charAt(j)时，我们需要从next[j - 1]中获取新的j
            // 直到我们发现有dest.charAt(i) == dest.charAt(j)成立才退出
            // 以上为KMP算法的核心思想
            // 例如dest = "AAAB"，如果没有下面这行代码，会返回[0, 1, 2, 2]，而正确的结果应为[0, 1, 2, 0]
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }

            // 当dest.charAt(i) == dest.charAt(j)满足时，部分匹配值就+1
            // 例如dest = "AAA"，此时返回[0, 1, 2]
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}