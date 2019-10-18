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

/*
方法二：
利用二维数组由上到下，由左到右递增的规律，
那么选取右上角或者左下角的元素a[row][col]与target进行比较，
当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,
即col--；
当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,
即row++；
*/
public class Solution {
    public boolean Find(int target, int [][] array) {
        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col])
                return true;
            else if (target > array[row][col])
                row++;
            else 
                col--;
        }
        return false;
    }
}
