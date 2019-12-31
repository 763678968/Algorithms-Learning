class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }

    private List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // 将问题拆分为若干个两数之和子问题，进行递归
        if (k == 2) {
            // two pointers from left and right
            int left = start, right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> path = new ArrayList<Integer>();
                    path.add(nums[left]);
                    path.add(nums[right]);
                    res.add(path);
                    // 去除重复组合
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++; right--;
                } else if (sum < target)
                    left++;
                else
                    right--;
            }
        } else {
            // k数之和，当k不为2时，划分为子问题
            // 以k=3为例，i遍历到len-2为止，因此右侧边界为len-(k-1)
            for (int i = start; i < len-(k-1); i++) {
                if (i > start && nums[i] == nums[i-1]) continue;
                // 如果当前元素为nums[i]，从右侧剩余第一个元素nums[i+1]开始，
                // 划分为k-1数之和的子问题，此时待求的和为sum-nums[i]
                List<List<Integer>> temp = kSum(nums, i+1, k-1, target-nums[i]);
                for (List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                res.addAll(temp);
            }
        }
        return res;
    }
}
