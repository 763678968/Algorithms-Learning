// 方法一
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        if (array == null || length <= 0)
            return 0;
        
        if (length == 1)
            return array[0];
        
        int[] tempArray = new int[length];
        for (int i = 0; i < length; i++) {
            tempArray[i] = array[i];
        }

        for (int i = 0; i < length; i++) {
            // 后面需要用0来代表抹除数字，所以对0要做特殊处理
            if (tempArray[i] == 0)
                continue;
            
            for (int j = i+1; j < length; j++) {
                if (tempArray[i] != tempArray[j] && tempArray[j] != 0) {
                    tempArray[i] = 0; // 此处用0代表抹去该数字
                    tempArray[j] = 0;
                    break;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.println(tempArray[i]);
        }
        
        // 找出未被抹去的数字
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (tempArray[i] != 0) {
                result = tempArray[i];
                break;
            }
        }
        
        int times = 0;
        for (int i = 0; i < length; i++) {
            if (result == array[i])
                times++;
        }
        
        if (times*2 < length)
            result = 0;
        
        return result;
    }
}

// 方法二：阵地攻守思想
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        if (array == null || length <= 0)
            return 0;
        
        int result = array[0];
        int times = 1;
        for (int i = 1; i < length; i++) {
            if (times == 0) {
                result = array[i];
            } else {
                if (array[i] == result) {
                    times++;
                } else {
                    times--;
                }
                
            }
        }
        
        times = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == result)
                times++;
        }
        
        if (times*2 <= length)
            result = 0;
        
        return result;
    }
}
