class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        /**
         * 先将字符串p中的字符存储到HashMap中，key为字母，value为出现次数
         * 令end指针从头遍历字符串s，与begin指针建立一个滑动窗口
         * 统计窗口中各个字符的出现次数与HashMap中存储的是否相同，不同就切换到下一个窗口
         * 当窗口右端到达s末端，结束
         */
        List<Integer> result = new LinkedList<>();
        if (p.length() > s.length()) return result;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 设置一个计数器，用于统计p中不同字母的个数，注意此处为map的size()
        // 而不是p的length()，因为p中可能存在重复的字符
        int counter = map.size();

        int begin = 0, end = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            // 如果map中存在相应的字母，就将map中字母出现的次数-1
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                // 如果某个字母出现的频率为0，则map中剩余的不同字母的数量-1，于是计数器-1
                if (map.get(c) == 0) counter--;
            }
            end++;

            // 与上面的end指针操作相反，当counter为零时，开始移动begin指针
            while (counter == 0) {
                char tempc = s.charAt(begin);
                // 如果map中存在begin指针处的元素，就将map中该字母出现的次数+1
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    // 如果map中某个字母出现的频率大于0，就将计数器counter+1，表示map中至少存在一个字母的频率不为一
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                // 如果当前窗口的长度等于p的长度，则是一个满足条件的窗口，将begin指针的值加入结果集
                if (end - begin == p.length()) {
                    result.add(begin);
                }
                begin++;
            }
        }
        return result;
    }
}
