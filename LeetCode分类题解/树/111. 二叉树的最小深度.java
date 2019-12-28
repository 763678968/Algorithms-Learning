class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        // 当左子树/右子树深度为0时，最小深度等于右子树/左子树深度+1，这里的+1表示加上根节点
        if (leftDepth == 0 || rightDepth == 0) return leftDepth + rightDepth + 1;
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
