// 动态规划
public class Solution {
    public int cutRope(int target) {
        if (targe
            t <= 1)
            return 0;
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;
        
        int[] result = new int[target+1]; // 用于存放最大乘积值
        
        // 以下为不可分割的最小单元
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        
        // 开始从下到上计算长度为i绳子的最大乘积值result[i]
        for (int i = 4; i <= target; i++) {
            int max = 0;
            // 计算不同长度的乘积，找出最大的乘积
            for (int j = 1; j <= i / 2; j++) {
                if (max < result[j] * result[i - j])
                    max = result[j] * result[i - j];
            }
            result[i] = max;
        }
        return result[target];
    }
}

// 贪婪算法
public class Solution {
    public int cutRope(int target) {
        if (target <= 1)
            return 0;
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;
        
        int timesOf3 = target / 3;
        if (target%3 == 0)
            return (int) Math.pow(3, timesOf3);
        if (target%3 == 1)
            return (int) Math.pow(3, timesOf3-1) * 4;
        return (int) Math.pow(3, timesOf3) * 2;
    }
}
