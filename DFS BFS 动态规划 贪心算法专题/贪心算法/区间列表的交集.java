// LeetCode 986.区间列表的交集
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        // 维护一对双指针，分别操作两个列表
        int i = 0, j = 0;
        // 当任何一个列表遍历完成，就结束循环
        while (i < A.length && j < B.length) {
            // 分别记录A区间和B区间的左右端点
            int A_start = A[i][0], A_end = A[i][1];
            int B_start = B[j][0], B_end = B[j][1];
            // 通过“两个区间不重叠”的否命题得到下面这个重叠区间的判别条件
            if (A_end >= B_start && A_start <= B_end) {
                // 将交集加入到结果集中，左端点为两区间的较大值，右端点为两区间的较小值
                res.add(new int[]{Math.max(A_start, B_start), Math.min(A_end, B_end)});
            }
            // 更新指针，通过比较两个区间的右端点实现
            if (A_end <= B_end) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}