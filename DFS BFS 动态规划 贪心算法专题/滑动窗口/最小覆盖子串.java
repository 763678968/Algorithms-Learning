// LeetCode 76.最小覆盖子串
class Solution {
    public String minWindow(String s, String t) {
        // 创建哈希表window、need，分别维护窗口中的元素、符合要求的元素
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c :t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 左右指针
        int left = 0, right = 0;
        // 保存符合要求的字符的数量，当valid等于need中的元素数量时，说明满足条件
        int valid = 0;
        // 使用start保存最小子串的起点，len保存最小子串的长度
        int start = 0, len = Integer.MAX_VALUE;

        // 开始滑动，直到右指针right到达字符串s的末端
        while (right < s.length()) {
            // 移动右指针，并更新窗口中的数据
            // 获取右指针处即将进入窗口的字符
            char c = s.charAt(right);
            // 移动右指针，扩大窗口
            right++;
            // 如果need中包含当前的字符，就更新window和valid
            if (need.containsKey(c)) {
                // 将当前字符放入窗口中
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果窗口中当前字符的数量等于need中的数量，就将valid++，表示当前字符已经匹配完成
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 移动左指针
            while (valid == need.size()) {
                // 更新最小子串的起点和长度
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 获取即将移出窗口的字符
                char ch = s.charAt(left);
                // 移动左指针，缩小窗口
                left++;
                if (need.containsKey(ch)) {
                    if (window.get(ch).equals(need.get(ch))) {
                        valid--;
                    }
                    window.put(ch, window.get(ch) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}