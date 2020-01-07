class Solution {
    public int firstUniqChar(String s) {
        // 本题如果不限定字符串中的字符全部为英文小写字符，
        // 则可以创建一个256长度的int数组，表示包含所有的ASCII码范围
        // 即int[] count = new int[256];
        // 后面统计字符出现次数时，也不需要 - 'a'
        int[] count = new int[26];
        // 第一次遍历字符串，将各个字符出现次数按照ASCII码值位置存入数组
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        // 第二次遍历字符串，查找第一个出现次数为1的字符
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "ababqdd";
        System.out.println(firstUniqChar(s));
    }
}
