class Solution {
    public String minWindow(String s, String t) {
        /**
         * 1.定义两个指针start、end来表示一个窗口
         * 2.向右移动end指针，来查找满足条件的窗口
         * 3.如果找到满足条件的窗口，向右移动start指针，来缩小窗口
         */
        // 定义一个数组作为哈希表，此处定义128是因为ASCII码，A：65，z：122
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            // 每遍历到一个元素，就在哈希表中将该元素的出现次数+1
            map[c]++;
        }

        // minStart：最小子串的起始位置，minLen：最小子串的长度，count：T中需要匹配的字符数量（上述条件1）
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, count = t.length();
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1] > 0) count--;
            // 哈希表中相应元素的剩余个数-1
            map[c1]--;
            end++;
            // 需要匹配的字符数量为0，即已经找到满足条件的窗口（上述条件2）
            while (count == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                // 开始向右移动start指针（上述条件3）
                char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) count++;
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
