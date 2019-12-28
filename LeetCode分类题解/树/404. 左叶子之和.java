class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        // 判断是否当前节点是否存在左节点
        if (root.left != null) {
            // 判断左节点是否为叶子节点，如果是叶子节点，将叶子节点的值加入sum
            if (root.left.left == null && root.left.right == null) sum += root.left.val;
            // 如果不是叶子节点，则继续查找当前节点的左节点
            else sum += sumOfLeftLeaves(root.left);
        }
        // 查找当前节点右节点中的左节点
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
