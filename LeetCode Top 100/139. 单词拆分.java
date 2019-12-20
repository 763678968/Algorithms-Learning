class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // res[i]代表[0,i)的子串是否可以匹配字典中的字符串，此处+1是用来存储res[0]，即[0,0)，空字符串是否可以匹配字典中的字符串
        boolean[] res = new boolean[s.length() + 1];
        // 根据题意，空字符串可以被空格分割，所以为true
        res[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (res[j] && wordDict.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}
// 输出的res数组：[true false false false true false false false true]

// 优化写法
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length() + 1];
        // 用HashSet存储字典，查找效率更高
        Set<String> dict = new HashSet<>();
        dict.addAll(wordDict);

        res[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            // 从后往前遍历，可以减少重复遍历的次数
            for (int j = i - 1; j >= 0; j--) {
                if (res[j] && dict.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}
