class Solution {
    // 所有符合条件路径的集合
    List<List<Integer>> result = new ArrayList<>();
    // 单条路径节点元素的集合
    ArrayList<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return null;
        }

        // 先将根节点加入路径集合中
        list.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            // sum等于0，并且当前节点是叶子节点，则说明该路径符合条件
            result.add(new ArrayList<>(list));
        }
        // 在左子树递归查找
        pathSum(root.left, sum);
        // 在右子树递归查找
        pathSum(root.right, sum);
        // 如果当前路径已经到了叶子节点也不符合条件，则退回其父节点
        // 深度遍历完一遍路径后要回退，将list中最后一个节点删除
        list.remove(list.size() - 1);
        return result;
    }
}