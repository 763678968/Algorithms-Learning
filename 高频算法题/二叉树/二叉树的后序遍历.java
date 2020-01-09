// 递归（直接打印）
class Solution {
    public void postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.println(root.val);
        }
    }
}


// 递归（输出ArrayList）
class Solution {
    ArrayList<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            result.add(root.val);
        }
        return result;
    }
}


// 非递归
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        /**
         * 前序遍历输出顺序为root → left → right
         * 后序遍历输出顺序为left → right → root
         * 将后序遍历倒序，则变为root → right → left
         * 倒序后的序列，与前序遍历相比，只需要将left、right入栈顺序交换即可
         */
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            res.add(node.val);
            // 因此这里先将left入栈，保证right先出栈
            stack.push(node.left);
            stack.push(node.right);
        }
        // 将序列从root → right → left反转为left → right → root
        Collections.reverse(res);
        return res;
    }
}