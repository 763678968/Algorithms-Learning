// 递归实现
public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }
    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        // 为镜像的条件：1.左右节点值相等，2.对称的子树也是左右节点值相等
        return left.val == right.val && isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
}

// DFS实现
 boolean isSymmetricalDFS(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(pRoot.left);
        s.push(pRoot.right);
        while(!s.empty()) {
            TreeNode right = s.pop();//成对取出
            TreeNode left = s.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            //成对插入
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }
    
    // BFS实现
    boolean isSymmetricalBFS(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        Queue<TreeNode> s = new LinkedList<>();
        s.offer(pRoot.left);
        s.offer(pRoot.right);
        while(!s.isEmpty()) {
            TreeNode left= s.poll();//成对取出
            TreeNode right= s.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            //成对插入
            s.offer(left.left);
            s.offer(right.right);
            s.offer(left.right);
            s.offer(right.left);
        }
        return true;
    }
