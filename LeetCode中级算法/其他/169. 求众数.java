class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i=1; i<nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                count++;
            } else count--;
        }
        return major;
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
// Sorting

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        // Hashtable<Integer, Integer> myMap = new Hashtable<Integer, Integer>();
        int ret = 0;
        for (int num : nums) {
            if (!myMap.containsKey(num))
                myMap.put(num, 1);
            else
                myMap.put(num, myMap.get(num)+1);
            if (myMap.get(num)>nums.length/2) {
                ret = num;
                break;
            }
        }
        return ret;
    }
}
// Hashtable

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, ret = 0;
        for (int num : nums) {
            if (count == 0)
                ret = num;
            if (num != ret)
                count--;
            else 
                count++;
        }
        return ret;
    }
}
// Moore voting algorithm

class Solution {
    public int majorityElement(int[] nums) {
        int[] bit = new int[32];
        for (int num : nums)
            for (int i=0; i<32; i++) 
                if ((num>>(31-i) & 1) == 1)
                    bit[i]++;
        int ret = 0;
        for (int i=0; i<32; i++) {
            bit[i] = bit[i] > nums.length/2 ? 1 : 0;
            ret += bit[i] * (1<<(31-i));
        }
        return ret;
    }
}
// 位操作，较慢
