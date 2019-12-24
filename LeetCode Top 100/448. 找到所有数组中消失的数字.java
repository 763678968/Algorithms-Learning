class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /**
         * 两次遍历数组
         * 第一次遍历，将各数字相应下标处的元素置为负数
         * 如果该数字重复出现，则不需要再次取相反数，因此需要(nums[val] > 0)判断
         * 第二次遍历数组，还为正值的元素下标+1，即为缺失的元素
         */
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0)
                nums[val] = -nums[val];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                res.add(i + 1);
        }
        return res;
    }
}
