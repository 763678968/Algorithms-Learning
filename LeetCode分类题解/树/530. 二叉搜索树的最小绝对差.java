class Solution {
    int minDiff = Integer.MAX_VALUE;
    TreeNode preNode = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return minDiff;
        getMinimumDifference(root.left);
        if (preNode != null) minDiff = Math.min(minDiff, root.val - preNode.val);
        preNode = root;
        getMinimumDifference(root.right);
        return minDiff;
    }
}
