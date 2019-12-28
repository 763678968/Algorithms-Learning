class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricCore(root.left, root.right);
    }

    private boolean isSymmetricCore(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetricCore(left.left, right.right) && isSymmetricCore(left.right, right.left);
    }
}
