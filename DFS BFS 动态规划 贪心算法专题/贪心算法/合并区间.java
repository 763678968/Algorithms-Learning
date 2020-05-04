// LeetCode 56.合并区间
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return null;
        }

        // 按照区间左端点排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        // 将排好序的第一个区间加入结果集中
        int[] newInterval = intervals[0];
        res.add(newInterval);
        for (int[] interval : intervals) {
            // 如果当前区间左端点小于等于新区间右端点，表明有重叠
            // 取两者右端点的较大值作为新区间的右端点
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
                // 如果区间不存在重叠，则直接令新区间等于当前区间
            } else {
                newInterval = interval;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}