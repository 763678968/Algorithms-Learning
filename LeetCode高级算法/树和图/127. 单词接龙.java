class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);
        int len = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            Set<String> tmp = new HashSet<>();
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            set.removeAll(beginSet);
            len++;
            for (String s :
                    beginSet) {
                // transform
                char[] chs = s.toCharArray();
                for (int k = 0; k < s.length(); k++) {
                    char ch = chs[k];
                    for (char i = 'a'; i <= 'z'; i++) {
                        chs[k] = i;
                        String str = String.valueOf(chs);
                        if (endSet.contains(str))
                            return len;
                        if (!visited.contains(str) && set.contains(str)) {
                            tmp.add(str);
                            visited.add(str);
                        }
                    }
                    chs[k] = ch;
                }
            }

            beginSet = tmp;
        }
        return 0;
    }
}

// BFS
