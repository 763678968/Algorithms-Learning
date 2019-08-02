class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums);   // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;   // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
// 可以与78、90、47、39、40、131题对照

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ll = new ArrayList<>();
        if (nums == null) return ll;
        
        int[] visited = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        
        permuteHelper(ll, nums, 0);
        
        return ll;
    }
    
    private void permuteHelper(List<List<Integer>> ll, int[] nums, int j) {
        if (j == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            ll.add(list);
        }
        
        for (int i=j; i < nums.length; i++) {
            swap(nums, i, j);
            permuteHelper(ll, nums, j+1);
            swap(nums, i, j);
        }
        return;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
} // 较快
