// 无序数组的两数之和问题
// 方法一：暴力法
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}

// 方法二：哈希表
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }

        // 将数字的下标和值存入map中
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}


// 有序数组的两数之和问题，双指针
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                result[0] = left;
                result[1] = right;
                return result;
            }
        }
        return result;
    }
}