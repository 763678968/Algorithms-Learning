class Solution {
    public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }
}
// 最简单的思路，Arrays.sort()方法

class Solution {
    public int findKthLargest(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
// 优先队列PriorityQueue、offer()方法、poll()方法、peek()方法

class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
    
    private int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (i < hi && less(a[++i], a[lo]));
            while (j > lo && less(a[lo], a[--j]));
            if (i >= j) {
                break;
            }exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    
    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    private boolean less(int v, int w) {
        return v < w;
    }
}
// 方法三

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
    
    private void shuffle(int a[]) {
        final Random random = new Random();
        for (int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }
    
    private int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (i < hi && less(a[++i], a[lo]));
            while (j > lo && less(a[lo], a[--j]));
            if (i >= j) {
                break;
            }exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    
    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    private boolean less(int v, int w) {
        return v < w;
    }
}
// 通过将第三种方法的输入进行随机化，保证了运行时间为O(N)，使用了random.nextInt()方法
