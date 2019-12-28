class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 定义一个指针cur，方便操作
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            // 一直循环cur = cur.left，遍历到整棵树的最左侧节点，并依次入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 然后弹出第一个（最左侧）节点
            cur = stack.pop();
            // 将这个节点的值添加到结果集中
            list.add(cur.val);
            // 同时，将指针指向弹出节点的右子节点
            // 之后进入到第二个while循环中
            // 1.如果刚刚弹出的节点没有右子节点，则while循环不做，再次执行stack.pop()，相当于弹出刚才的节点的父节点
            // 2.如果刚刚弹出的节点有右子节点，则进入到while循环时，一直向下遍历到最左侧节点，重复上述的过程
            cur = cur.right;
        }
        return list;
    }
}
