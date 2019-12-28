class Solution {
    int path = 0;
    public int longestUnivaluePath(TreeNode root) {
        longestUnivaluePathWithRoot(root);
        return path;
    }

    public int longestUnivaluePathWithRoot(TreeNode root) {
        if (root == null) return 0;
        int left = longestUnivaluePathWithRoot(root.left);
        int right = longestUnivaluePathWithRoot(root.right);
        int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
        path = Math.max(path, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
