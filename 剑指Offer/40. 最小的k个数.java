// 解法一
public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> leastNumbers = new ArrayList<Integer>();
        while(input==null || k<=0 || k>input.length)
            return leastNumbers;
        int start=0;
        int end=input.length-1;
        int index=partition(input,start,end);
        while(index!=k-1){
            if(index<k-1){
                start=index+1;
                index=partition(input,start,end);
            }else{
                end=index-1;
                index=partition(input,start,end);
            }
        }
        for(int i=0;i<k;i++){
            leastNumbers.add(input[i]);
        }
        return leastNumbers;
    }
      
    private int partition(int[] arr, int start,int end){
        int pivotKey=arr[start];
        while(start<end){
            while(start<end && arr[end]>=pivotKey)
                end--;
            swap(arr,start,end);
            while(start<end && arr[start]<=pivotKey)
                start++;
            swap(arr,start,end);
        }
        return start;
    }
      
    private void swap(int[] arr, int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
    
// 解法二：最大堆
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if (input == null || length <= 0)
            return result;
        if (k > length || k == 0)
            return result;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}
