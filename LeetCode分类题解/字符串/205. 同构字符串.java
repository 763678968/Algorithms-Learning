class Solution {
    public boolean isIsomorphic(String s, String t) {
        // 创建两个数组，分别用于保存s、t字符串中遍历过的字符在字符串中出现的位置
        // 这里开辟256空间的数组是因为ASCII码的范围位于0~255范围内
        // 也可以定义为new int[128]（8位ASCII码）
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            // 如果两个字符串中相同位置的字符，上次出现的位置不相同，则不是同构的
            if (preIndexOfS[sc] != preIndexOfT[tc]) return false;
            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }
        return true;
    }
}