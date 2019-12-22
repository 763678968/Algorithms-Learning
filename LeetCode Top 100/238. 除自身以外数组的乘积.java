class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 创建一个数组，保存当前数字左侧的乘积，同时也作为最后的结果数组
        int[] res = new int[nums.length];
        // 第一个元素左侧没有元素，其左侧乘积用1代替
        res[0] = 1;
        // 计算左侧乘积，存入res数组
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // 创建一个right变量，用于保存当前数字右侧的乘积
        int right = 1;
        // 从后往前计算，将相应数字的左侧乘积left[i]与右侧乘积right进行相乘
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i < nums.length - 1)
                right *= nums[i + 1];
            res[i] *= right;
        }
        return res;
    }
}
