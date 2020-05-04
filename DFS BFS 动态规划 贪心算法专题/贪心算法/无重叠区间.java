// LeetCode 435.无重叠区间
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }

        // 将所有区间按照右端点升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 至少会有一个区间，作为不重叠区间
        int count = 1;
        // 取右端点最小的区间（也就是排序后的第一个区间）的右端点值
        int end = intervals[0][1];
        // 遍历其余区间，当区间的左端点大于等于上一个区间的右端点时，即为不重叠
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                count++;
                // 将当前区间的右端点作为新的端点
                end = interval[1];
            }
        }
        // 题目要求统计需要去除的重叠区间数量，所以这里求差值
        return intervals.length -  count;
    }
}