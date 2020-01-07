class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        // 定义一个map，key：元素，value：元素出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;

        // i代表滑动窗口的右端，j代表滑动窗口的左端
        for (int i = 0, j = 0; i < s.length(); i++) {
            // 如果当前元素在map中存在
            if (map.containsKey(s.charAt(i))) {
                // 就将滑动窗口左端j移到元素上次出现位置的右侧，或者保持目前最大的j
                // Math.max(j)主要对应于abba这种对称的结构，遍历到第二个b时，j指向第二个b
                // 而之后遍历到第二个a时，如果没有Math.max(j)这部分代码，j会指向第一个b处
                // 就会出现错误
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            // 将当前遍历到的字符的位置存入map
            map.put(s.charAt(i), i);
            // 子串的长度为i - j + 1
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}