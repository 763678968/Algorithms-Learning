// 递归
class Solution {
    ArrayList<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }
        return result;
    }
}


// 迭代
class Solution {
    /** 当前节点会把自己的左边界一次性都压到栈里，然后依次弹出，
     * 直到遇到一个有右孩子的节点，处理它的右孩子，这样就模拟了
     * “左、中、右”这样的一个过程 */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 定义一个指针cur进行节点操作
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
            // 1.如果刚刚弹出的节点没有右子节点，则while循环不做，再
            // 次执行stack.pop()，相当于弹出刚才的节点的父节点
            // 2.如果刚刚弹出的节点有右子节点，则进入到while循环时，
            // 一直向下遍历到最左侧节点，重复上述的过程
            cur = cur.right;
        }
        return list;
    }
}