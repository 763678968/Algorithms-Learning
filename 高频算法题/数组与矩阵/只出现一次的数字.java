// 只出现一次的数字I
// 某个元素只出现一次以外，其余每个元素均出现两次
class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++)
            result ^= nums[i];
        return result;
    }
}


// 只出现一次的数字II
// 某个元素只出现一次以外，其余每个元素均出现三次
// 这个做法适用于其他元素出现任何次的情况
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 创建一个bits数组，用于保存所有数字的每个二进制位中1的总数
        int[] bits = new int[32];
        // 依次遍历数组中的每一个数字
        for (int i = 0; i < nums.length; i++) {
            // 每次将数字右移，检查数字的每一位是否为1，
            // 出现1的二进制位就在bits数组中相应位置+1
            for (int j = 0; j < 32; j++) {
                bits[j] += ((nums[i] >> j) & 1);
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // 如果bits数组中某一位不能被3整除，说明
            // 只出现一次的那个数字在这个二进制位也为1
            if (bits[i] % 3 != 0) {
                // 于是将该位为1的二进制数累加起来
                result += (1 << i);
            }
        }
        return result;
    }
}


// 只出现一次的数字III
// 除了某两个元素只出现一次以外，其余每个元素均出现两次
class Solution {
    public int[] singleNumber(int[] nums) {
        /**
         * 两次遍历数组
         * 1.第一次遍历，将所有元素进行异或，最后得到只出现一次的两个数字的异或结果
         * 2.这两个数字一定具有不同的二进制位，从不同的二进制位中挑选出一个位作为标记位，例如
         * 上一步中异或所得结果的最后一位1，则两个数字中，有一个在这位为0，另一个在这位为1
         * 3.第二次遍历，根据标记位为0或1，将数组中的数字分为两组，分别异或
         * 4.最后每组中剩余的数字就是只出现一次的数字
         */
        // 定义diff为两个只出现一次的数字的异或结果
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff ^= nums[i];
        }

        // 保留两数字异或结果中的最后一位1作为标记位
        diff &= (-diff);

        int[] res = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) // 标记位为0的元素
                res[0] ^= num;
            else // 标记位为1的元素
                res[1] ^= num;
        }
        return res;
    }
}