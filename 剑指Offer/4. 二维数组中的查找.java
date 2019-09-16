/*
方法一：把每一行看成有序递增的数组，利用二分查找，通过遍历每一行得到答案，时间复杂度O(nlogn)
*/
public class Solution {
    public boolean Find(int target, int [][] array) {   
        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target > array[i][mid]) 
                    low = mid + 1;
                else if (target < array[i][mid])
                    high = mid - 1;
                else 
                    return true;
            }
        }
        return false;
    }
}
