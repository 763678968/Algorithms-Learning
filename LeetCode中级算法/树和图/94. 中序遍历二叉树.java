/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
// 使用List、Stack

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        search(root, list);
        return list;
    }
    
    private void search(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            search(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            search(node.right, list);
        }
    }
}
// 方法二：递归
// 与230.二叉搜索树中第K小的元素 98.验证二叉搜索树 三道题对照着看
