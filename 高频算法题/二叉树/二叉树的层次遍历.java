class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 保存最终结果
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        // 创建一个队列用于遍历每层的节点，则队列的大小为每层节点的个数
        Queue<TreeNode> queue = new LinkedList<>();
        // 先将根节点入队
        queue.add(root);

        while (!queue.isEmpty()) {
            // 创建一个list保存一层的节点值
            List<Integer> list = new ArrayList<>();
            // 每层节点的个数
            int count = queue.size();
            for (int i = 0; i < queue.size(); i++) {
                // 将节点值保存在list中
                TreeNode node = queue.poll();
                list.add(node.val);
                // 将下一行节点入队
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
}