class Solution {
    /* 遍历所有长方形计算其上部面积，其中水的面积 = 高度 - min（左侧最高长方形，右侧最高长方形）
     * [如果此值为正数]。第一次遍历时计算左侧最高长方形，第二次遍历时计算右侧最高长方形、
     * 长方形的最小值和差值 */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        /* 计算左侧最大长方形 */
        int[] leftMaxes = new int[height.length];
        int leftMax = height[0];
        for (int i = 0; i < leftMaxes.length; i++) {
            leftMax = Math.max(leftMax, height[i]);
            leftMaxes[i] = leftMax;
        }

        int sum = 0;

        /* 计算右侧最大长方形 */
        int rightMax = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            // 计算当前位置的左侧最大高度和右侧最大高度中的较小值
            int secondTallest = Math.min(rightMax, leftMaxes[i]);

            /* 如果左侧或者右侧有更高的长方形，则有积水。计算面积并计入总和中 */
            if (secondTallest > height[i]) {
                sum += secondTallest - height[i];
            }
        }
        return sum;
    }
}