// 先将数组排序，再使用双指针
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        // 先将数组排序，便于使用双指针
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 排除重复的元素
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                // 每次循环都重新初始化左右指针
                int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // 去除头尾指针遍历到的重复元素
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        // 如果没有重复元素，同时移动头尾指针，进行下一次判断
                        left++; right--;
                    } else if (nums[left] + nums[right] > sum) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}