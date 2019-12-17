class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
         * 首先对输入数组进行特殊输入判断
         * 然后创建一个哈希表用于存储一组字母所对应的不同组合HashMap<String, ArrayList<String>>
         *     键：将字符串数组的每一个元素，转化为char数组，并进行排序Arrays.sort(charArray)
         *     值：遍历字符串数组，如果排序后的键在哈希表中已经存在，就添加到ArrayList<String>中
         * 最后将哈希表中不同key所对应的value放入一个ArrayList中，返回结果
         */
        if (strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String keyStr = String.valueOf(temp);
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
