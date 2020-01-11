// 递归
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}

// 迭代
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null || node.right != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }
}