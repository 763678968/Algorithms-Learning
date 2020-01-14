// 非递归实现
class Solution {
    public static int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target < array[mid]) {
                end = mid - 1;
            } else if (target > array[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,8,9};
        System.out.println(binarySearch(array, 8));
    }
}


// 递归实现
class Solution {
    public static int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        return binarySearch(array, target, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int target, int start, int end) {
        int mid = start + (end - start) / 2;

        // 终止递归的条件
        if (array[mid] == target) {
            return mid;
        }
        if (start >= end) {
            return -1;
        }

        if (target < array[mid]) {
            return binarySearch(array, target, start, mid - 1);
        } else if (target > array[mid]) {
            return binarySearch(array, target, mid + 1, end);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,3,4,4,4,5,6,8,9};
        System.out.println(binarySearch(array, 1));
    }
}

