class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        // 遍历到叶子节点时返回-1
        if (root.left == null && root.right == null) return -1;

        int left = root.left.val;
        int right = root.right.val;

        // 如果左/右子节点值与根节点值相同，需要继续寻找下一个候选元素
        if (root.left.val == root.val) left = findSecondMinimumValue(root.left);
        if (root.right.val == root.val) right = findSecondMinimumValue(root.right);

        // 如果left、right都不是叶子节点，返回二者中较小的那个
        if (left != -1 && right != -1) return Math.min(left, right);
        else if (left != -1) return left;
        else return right;
    }
}
