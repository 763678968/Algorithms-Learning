public class Solution {
    public int maxValueOfGifts(int[][] values) {
        if (values == null || values.length <= 0 || values[0].length <= 0)
            return 0;
        int rows = values.length;
        int cols = values[0].length;
        int[] maxValue = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0)
                    up = maxValue[j];
                if (j > 0)
                    left = maxValue[j - 1];
                maxValue[j] = Math.max(up, left) + values[i][j];
            }
        }
        return maxValue[cols-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] values = {{1,10,3,8}, {12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(s.maxValueOfGifts(values));
    }
}
