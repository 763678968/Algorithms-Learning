// 哈希表
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // 用哈希表保存遍历过的节点，如果k - root.val == 保存过的节点值，则返回true
        return findTargetCore(root, k, new HashSet<>());
    }

    private boolean findTargetCore(TreeNode root, int k, Set<Integer> set) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return findTargetCore(root.left, k, set) || findTargetCore(root.right, k, set);
    }
}

// 将二叉搜索树转换为数组，使用双指针在数组中查找两数之和
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        /**
         * 1.通过中序遍历，将二叉搜索树转化为排序数组
         * 2.在排序数组中通过双指针向数组中间靠拢，进行查找
         */
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0, j = list.size() - 1; i < j; ) {
            if (list.get(i) + list.get(j) == k) return true;
            else if (list.get(i) + list.get(j) < k) i++;
            else j--;
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
