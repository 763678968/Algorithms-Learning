// 递归
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}


// 迭代 DFS
class Solution {
    /**
     * 使用栈保存成对的节点，出栈的时候也是成对的
     * 1.如果都为空，继续
     * 2.一个为空，返回false
     * 3.两节点均不为空，比较当前值，值不相等，返回false
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            // 成对取出
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            // 成对入栈
            // 左节点的左节点和右节点的右节点
            stack.push(left.left);
            stack.push(right.right);
            // 左节点的右节点和右节点的左节点
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }
}