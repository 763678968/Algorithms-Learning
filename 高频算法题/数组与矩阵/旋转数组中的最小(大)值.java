// 旋转数组的最小值
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        // 输入数组为空
        if (array == null || array.length == 0) {
            return 0;
        }

        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            // 例如：[3,4,5,6,0,1,2]，此时最小数字出现在mid的右边
            if (array[mid] > array[high]) {
                low = mid + 1;
                // 例如：[2,2,3,4,5,6,6]，此时最小数字出现在mid的左边，或者就是mid处元素
            } else if (array[mid] < array[high]) {
                // 如果查找范围缩小到只有两个数，例如:[2,4]，此时array[low]=2，array[high]=4
                // 则根据除法的偏左性，array[mid]会与array[low]相等，此时再令high = mid - 1
                // 会出现越界错误，因此high = mid，而上一种情况中的low = mid + 1
                high = mid;
                // 例如：[1,0,1,1,1]，此时无法判断最小数字的位置，需要令右指针-1缩小范围，然后再次查找
            } else {
                high = high - 1;
            }
        }
        return array[low];
    }
}

// 旋转数组的最大值
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        // 输入数组为空
        if (array == null || array.length == 0) {
            return 0;
        }

        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            // 例如：[3,4,5,6,0,1,2]，此时最大数字可能出现在mid的右边，或者就是mid处元素
            if (array[mid] > array[low]) {
                low = mid;
                // 例如：[4,5,2,2,3]，此时最大数字出现在mid的左边
            } else if (array[mid] < array[low]) {
                high = mid - 1;
            } else {
                low = low + 1;
            }
        }
        return array[high];
    }
}