// LeetCode 452.用最少数量的箭引爆气球
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int end = points[0][1];
        int count = 1;
        for (int[] point : points) {
            // 与 LeetCode 435.无重叠区间 的区别在于，本题两个区间端点相等也算重叠区间
            // 所以判断条件中不带等号
            if (point[0] > end) {
                count++;
                end = point[1];
            }
        }
        return count;
    }
}
