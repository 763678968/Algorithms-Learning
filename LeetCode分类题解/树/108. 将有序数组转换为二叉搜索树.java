class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 因为输入数组已经排序，所以分别取数组左半边、右半边作为左子树、右子树进行递归
        if (nums.length == 0) return null;
        return sortedArrayToBSTCore(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTCore(int[] nums, int low, int high) {
        if (low > high) return null; // 递归终止
        int mid = low + (high - low) / 2;
        // 取数组的中间元素，作为树的根节点
        TreeNode root = new TreeNode(nums[mid]);
        // 取数组的左半边构造左子树
        root.left = sortedArrayToBSTCore(nums, low, mid - 1);
        // 取数组的右半边构造右子树
        root.right = sortedArrayToBSTCore(nums, mid + 1, high);
        return root;
    }
}
