// 递归
class Solution {
    public TreeNode convert(TreeNode root) {
        if (root == null)
            return null;
        if (root.left==null && root.right==null)
            return root;

        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = convert(root.left);
        TreeNode current = left;

        // 2. 定位至左子树双链表最后一个节点
        while (current!=null && current.right!=null)
            current = current.right;

        // 3. 如果左子树链表不为空的话，将当前的根节点追加到左子树链表的末尾
        if (left != null) {
            current.right = root;
            root.left = current;
        }

        // 4. 将右子树构造成双链表，并返回链表头节点
        TreeNode right = convert(root.right);

        // 5. 如果右子树链表不为空的话，将该链表追加到根节点之后
        if (right != null) {
            right.left = root;
            root.right = right;
        }
        return left != null ? left : root;
    }
}


// 迭代
public class Solution {
    public TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode pre = null; // 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (isFirst) {
                root = current;// 将中序遍历序列中的第一个节点记为root
                pre = root;
                isFirst = false;
            } else {
                pre.right = current;
                current.left = pre;
                pre = current;
            }
            current = current.right;
        }
        return root;
    }
}