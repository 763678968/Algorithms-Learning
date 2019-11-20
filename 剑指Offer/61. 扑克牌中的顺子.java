// 题解1：需要排序
import java.util.Arrays;
public class Solution {
    public boolean isContinuous(int [] numbers) {
        int numOfZero = 0;
        int numOfInterval = 0;
        int length = numbers.length;
        if (length == 0)
            return false;
        Arrays.sort(numbers);
        for (int i = 0; i < length - 1; i++) {
            // 计算大小王数量
            if (numbers[i] == 0) {
                numOfZero++;
                continue;
            }
            // 含有对子，则不可能是顺子，直接返回
            if (numbers[i] == numbers[i+1])
                return false;
            numOfInterval += numbers[i+1] - numbers[i] - 1;
        }
        if (numOfZero >= numOfInterval)
            return true;
        return false;
    }
}


// 题解2：不需要排序，使用哈希表记录0~13各个数字出现的次数
public class Solution {
    public boolean isContinuous(int [] numbers) {
        int len = numbers.length;
        if (len == 0)
            return false;
        
        int[] d = new int[14];
        d[0] = -5;
        int max = -1;
        int min = 14;
        for (int i = 0; i < len; i++) {
            // 用哈希表存储0~13出现的次数
            d[numbers[i]]++;
            if (numbers[i] == 0)
                continue;
            // 除了0以外，如果出现重复数字，则没有顺子，直接返回false
            if (d[numbers[i]] > 1)
                return false;
            if (numbers[i] > max)
                max = numbers[i];
            if (numbers[i] < min)
                min = numbers[i];
        }
        if (max - min < 5)
            return true;

        return false;
    }
}
