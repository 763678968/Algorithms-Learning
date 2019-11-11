public class Solution {
boolean invalidInput = false;

    public int FindGreatestSumOfSubArray(int[] array) {

        int length = array.length;

        if (array == null || array.length <= 0) {
            invalidInput = true;
            return 0;
        }

        invalidInput = false;

        int curSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (curSum <= 0) {
                // 累加和为负数时，从下一个元素重新开始计算
                curSum = array[i];
            } else {
                // 累加和不为负数时，继续加上下一个元素
                curSum += array[i];
            }

            // 累加和大于最大和时，更新最大和的数值
            if (curSum > greatestSum)
                greatestSum = curSum;
        }
        return greatestSum;
    }
}
