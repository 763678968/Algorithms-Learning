class Solution {
    public int[][] merge(int[][] intervals) {
        /**
         * 从题目给定的两个示例来看，如果输入区间按顺序排列，左端点呈现逐渐增大的趋势，就不用考虑区间整个嵌套的问题
         * 所以首先对输入数组进行排序
         * 然后只需要比较本区间的右端点是否大于等于下一个区间的左端点即可
         * 如果满足条件，则令本区间的右端点等于下一区间的右端点
         */
        if (intervals.length <= 1)
            return intervals;

        // 对输入数组按照区间左端点进行升序排列
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            // 如果新区间右端点与下一区间左端点存在重叠，则令新区间的右端点等于下一个区间的右端点
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
            // 如果不存在重叠，则直接令新区间等于该区间
            else {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
