// 只能买卖一次 LeetCode 121
class Solution {
    public int maxProfit(int[] nums) {
        // 定义maxCur保存目前的利润
        int maxCur = 0;
        // 定义maxSoFar用于保存最大利润
        int maxSoFar = 0;
        // 依次求相邻两天的收益
        for (int i = 1; i < nums.length; i++) {
            // 如果某天的收益与先前的利润之和为负值，则之前的利润不可能是最大利润，置为0
            maxCur = Math.max(0, maxCur + (nums[i] - nums[i - 1]));
            // 更新最大利润
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}

// 可以买卖任意多次 LeetCode 122
class Solution {
    public int maxProfit(int[] nums) {
        // 定义total保存最大利润
        int total = 0;
        // 依次求相邻两天的收益
        for (int i = 0; i < nums.length - 1; i++) {
            // 只要后一天比前一天价格高，就进行一次买卖
            if (nums[i + 1] > nums[i]) {
                total += nums[i + 1] - nums[i];
            }
        }
        return total;
    }
}
