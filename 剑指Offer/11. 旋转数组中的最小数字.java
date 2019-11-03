import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        
        // 输入数组为空
        if (array.length == 0 || array == null)
            return 0;
        
        int low = 0; 
        int high = array.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                high = mid;
            } else {
                high = high - 1; // 首尾、中间元素相等，缩小查找范围
            }
        }
        return array[low];
    }
}
