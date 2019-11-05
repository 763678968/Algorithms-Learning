public class Solution {
    public void reOrderArray(int [] array) {
        if (array.length == 0 || array == null)
            return;
        
        int length = array.length;
        int low = 0;
        int high = length - 1;
        int temp;
        
        while (low < high) {
            // 向后移动low指针，直到它指向偶数
            while (low < length && ((array[low]&1) != 0))
                low++;
            // 向前移动high指针，直到它指向奇数
            while (high >= 0 && ((array[high]&1) == 0))
                high--;
            if (low < high) {
                temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }
    }
}
