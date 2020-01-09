// 递归（直接打印）
class Solution {
    public void preOrder(TreeNode root) {
        if (root != null) {
            // 中、左、右
            System.out.println(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}


// 递归（输出ArrayList）
class Solution {
    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> preOrder(TreeNode root) {
        if (root != null) {
            // 中、左、右
            result.add(root);
            preOrder(root.left);
            preOrder(root.right);
        }
        return result;
    }
}


// 非递归
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