class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            res.add(node.val);
            // 先将右子树入栈，保证出栈时左子树先遍历
            stack.push(node.right);
            stack.push(node.left);
        }
        return res;
    }
}
