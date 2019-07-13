public boolean containsDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
// 时间复杂度：O(N^2) 空间复杂度：O(1)

public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int ind = 1; ind < nums.length; ind++) {
            if(nums[ind] == nums[ind - 1]) {
                return true;
            }
        }
        return false;
    }
// 时间复杂度：O(NlgN) 空间复杂度：O(1)

public boolean containsDuplicate(int[] nums) {
    final Set<Integer> distinct = new HashSet<Integer>();
    for(int num : nums) {
        if(distinct.contains(num)) {
            return true;
        }
        distinct.add(num);
    }
    return false;
}
// 时间复杂度：O(N) 空间复杂度：O(N)
