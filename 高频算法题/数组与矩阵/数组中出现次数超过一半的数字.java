// 方法一：删除不同的数字
class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        if (array == null || length <= 0)
            return 0;
        if (length == 1)
            return array[0];

        // 创建一个临时数组，将array中的元素复制到tempArray中
        int[] tempArray = new int[length];
        for (int i = 0; i < length; i++) {
            tempArray[i] = array[i];
        }

        for (int i = 0; i < length; i++) {
            // 后面需要用0来代表抹除数字，所以对0要做特殊处理
            if (tempArray[i] == 0)
                continue;

            // 从i+1开始，向后遍历数组，如果i处的元素与遍历到的元素不相等
            // 则将i、j+1处的元素删掉（置为0）
            for (int j = i+1; j < length; j++) {
                if (tempArray[i] != tempArray[j] && tempArray[j] != 0) {
                    // 此处用0代表删掉该数字
                    tempArray[i] = 0;
                    tempArray[j] = 0;
                    break;
                }
            }
        }

        // 找出未被删掉的数字
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (tempArray[i] != 0) {
                result = tempArray[i];
                break;
            }
        }

        // 统计未被删掉的数字的出现次数
        int times = 0;
        for (int i = 0; i < length; i++) {
            if (result == array[i]) {
                times++;
            }
        }

        // 如果该未被删掉的数字的出现次数小于数组长度的一半
        // 或者数组中出现次数超过数组长度一半的数字就是0
        // 则令result = 0
        if (times*2 < length) {
            result = 0;
        }
        return result;
    }
}


// 方法二：阵地攻守
class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        if (array == null || length <= 0)
            return 0;

        int result = array[0];
        // 统计数字出现的次数
        int times = 1;
        for (int i = 1; i < length; i++) {
            // 如果出现次数为0，则表明“阵地失守”，需要重新设置result的值
            if (times == 0) {
                result = array[i];
            } else {
                // 如果当前数字与result相等，则result的出现次数+1
                if (array[i] == result) {
                    times++;
                    // 反之，则result的出现次数-1
                } else {
                    times--;
                }
            }
        }

        // 从头遍历数组，统计result出现的次数
        times = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == result)
                times++;
        }

        // 如果result的出现次数小于数组长度的一半，则返回0
        if (times * 2 <= length)
            result = 0;

        return result;
    }
}