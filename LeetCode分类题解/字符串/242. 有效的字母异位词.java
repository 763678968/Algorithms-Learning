class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        // 将s中各个字符的出现次数存入数组中，每出现一次就+1
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        // 将t中各个字符的出现次数存入数组中，每出现一次就-1
        // 如果s和t为字母异位词，则相同字符的出现次数应正负抵消，为0，否则不是字母异位词
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return true;
    }
}