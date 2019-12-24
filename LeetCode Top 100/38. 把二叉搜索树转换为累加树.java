class Solution {
    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }
    
    private int dfs(TreeNode root, int sum) {
        if (root == null) return sum;
        int right = dfs(root.right, sum);
        int left = dfs(root.left, root.val + right);
        root.val = root.val + right;
        return left;
    }
}
