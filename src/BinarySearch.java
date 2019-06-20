import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else                   return mid;
        }
        return -1;
    }

//    二分查找的递归实现
//    public static int rank(int key, int[] a) {
//        return rank(key, a, 0, a.length - 1);
//    }
//
//    public static int rank(int key, int[] a, int lo, int hi) {
//        // 如果key存在于a[]中，它的索引不会小于lo且不会大于hi
//        if (lo > hi) return -1;
//        int mid = lo + (hi - lo) / 2;
//        if      (key < a[mid]) return rank(key, a, lo, mid - 1);
//        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
//        else                   return mid;
//    }


    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);

        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1)
                StdOut.println(key);
        }
    }
}
