class Solution {
    public void sortColors(int[] nums) {
        /**
         * 将数组中的0移至开头，将2移至末尾，1留在中间
         * 使用双指针，zero表示0，two表示2，对数组进行遍历
         * 找到0就将当前元素交换到zero的位置，找到2就将当前元素交换到two的位置
         * 交换之后相应地将zero++或two--
         * 找到1时什么也不做，将遍历数组的指针i++
         * 当i与two相遇时退出循环
         */
        if (nums == null || nums.length < 2) return;

        int zero = 0;
        int two = nums.length - 1;

        for (int i = 0; i <= two; ) {
            if (nums[i] == 0) {
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                // 交换之后，当前i所在位置已经被占用，所以i++
                i++; zero++;
            } else if (nums[i] == 2) {
                int temp = nums[two];
                nums[two] = nums[i];
                nums[i] = temp;
                // 交换过来的元素有可能是0、1、2中的任何一个
                // 所以不做i++，下一轮循环继续比较
                two--;
            } else { // 遍历到1的情况
                i++;
            }
        }
    }
}
