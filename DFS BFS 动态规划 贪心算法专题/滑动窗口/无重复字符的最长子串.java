// LeetCode 3.无重复字符的最长子串
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int len = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 当窗口中出现重复元素时，移动左指针，进行收缩
            while (window.get(c) > 1) {
                char ch = s.charAt(left);
                left++;
                window.put(ch, window.get(ch) - 1);
            }
            // 当窗口收缩完成后，窗口中没有重复字符，更新len的值
            len = Math.max(len, right - left);
        }
        return len;
    }
}