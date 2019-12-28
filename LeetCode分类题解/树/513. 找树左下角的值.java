class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            // 先把右节点加入队列，再把左节点加入队列
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        // 最后取出的就是最左侧的节点
        return root.val;
    }
}
