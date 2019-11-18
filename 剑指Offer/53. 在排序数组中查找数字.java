public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int number = 0;
        int length = array.length;

        if (array!=null && length>0) {
            int first = GetFirstK(array, k, 0, length-1);
            int last = GetLastK(array, k, 0, length-1);

            if (first>-1 && last>-1)
                number = last - first + 1;
        }
        return number;
    }

    private int GetFirstK(int[] array, int k, int start, int end) {
        if (start > end)
            return -1;

        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];

        if (middleData == k) {
            if ((middleIndex>0 && array[middleIndex-1]!=k) || middleIndex==0 ) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return GetFirstK(array, k, start, end);
    }

    private int GetLastK(int[] array, int k, int start, int end) {
        int length = array.length;
        if (start > end)
            return -1;
        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];

        if (middleData == k) {
            if ((middleIndex<length-1 && array[middleIndex+1]!=k) || middleIndex==length-1 ) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleData < k) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }
        return GetLastK(array, k, start, end);
    }
    
    // 循环写法
    private int getLastK(int [] array , int k, int start, int end){
        int length = array.length;
        int mid = (start + end) >> 1;
        while(start <= end){
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else if(mid+1 < length && array[mid+1] == k){
                start = mid+1;
            }else{
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }
}

// 题解2
//因为data中都是整数，所以可以稍微变一下，不是搜索k的两个位置，而是搜索k-0.5和k+0.5
//这两个数应该插入的位置，然后相减即可。
public int GetNumberOfK(int [] array , int k) {
    return biSearch(array, k+0.5) - biSearch(array, k-0.5);
}

private int biSearch(int[] array, double num) {
    int start = 0;
    int end = array.length - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (array[mid] < num)
            start = mid + 1;
        else
            end = mid - 1;
    }
    return start;
}
