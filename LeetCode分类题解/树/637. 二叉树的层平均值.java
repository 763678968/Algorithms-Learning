class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            double sum = 0;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node != null) sum += node.val;
                // 将下一行的元素加入队列
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(sum / count);
        }
        return res;
    }
}
