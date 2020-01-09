class Solution {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // 求左右子树的最大深度
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // 对于每个节点，以当前节点为根结点的子树的最大直径
        // 等于这个根节点左、右子树的最大深度之和
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        // 最大深度等于左右子树中深度的较大值+1（+1表示加上根节点）
        return Math.max(leftDepth, rightDepth) + 1;
    }
}