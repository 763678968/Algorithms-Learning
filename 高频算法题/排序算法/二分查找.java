// 非递归形式
class Solution {
    // 基本形式：查找某个值
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 某个值可能出现了多次，查找左边界
    public int binarySearch_leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        // 最后检查left是否越界，因为上面的while循环的退出条件为left = right + 1
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    // 某个值可能出现了多次，查找右边界
    public int binarySearch_rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        // 最后检查right是否越界，因为上面的while循环的退出条件为right = left - 1
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
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

