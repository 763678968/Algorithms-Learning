class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        // 将nums中各个数字与其出现的次数存入map中
        for (Integer n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        // 将各个数字的出现频率存入bucket数组中，bucket的下标代表频率，bucket的元素代表数字
        for (Integer key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            // 如果该频率处没有元素，就在此处创建一个新的ArrayList
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            // 将该频率对应的元素添加到bucket中
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        // 倒序遍历bucket数组，遍历到的第一个元素就是频率最高的元素，以此类推
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k ; pos--) {
            // 如果bucket[pos]不为空，即pos频率存在，则将bucket[pos]添加到结果集res中
            if (bucket[pos] != null)
                res.addAll(bucket[pos]);
        }
        // 截取res的前k个元素，防止出现[1,1,1,2,2,3,3,4,4], k=2,返回[1,2,3,4]的情况
        // 即有多个频率相同的元素时，只考虑这些相同频率数字中的某一个即可
        return res.subList(0, k);
    }
}
