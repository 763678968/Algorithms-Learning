// 递归实现
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        if (pRootOfTree.left==null && pRootOfTree.right==null)
            return pRootOfTree;

        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;

        // 2. 定位至左子树双链表最后一个节点
        while (p!=null && p.right!=null)
            p = p.right;

        // 3. 如果左子树链表不为空的话，将当前pRootOfTree追加到左子树链表
        if (left != null) {
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }

        // 4. 将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(pRootOfTree.right);

        // 5. 如果右子树链表不为空的话，将该链表追加到pRootOfTree节点之后
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree;
    }
}

// 非递归实现
import java.util.Stack;
public TreeNode ConvertBSTToBiList(TreeNode root) {
    if(root==null)
        return null;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode p = root;
    TreeNode pre = null;// 用于保存中序遍历序列的上一节点
    boolean isFirst = true;
    while(p!=null||!stack.isEmpty()){
        while(p!=null){
            stack.push(p);
            p = p.left;
        }
        p = stack.pop();
        if(isFirst){
            root = p;// 将中序遍历序列中的第一个节点记为root
            pre = root;
            isFirst = false;
        }else{
            pre.right = p;
            p.left = pre;
            pre = p;
        }      
        p = p.right;
    }
    return root;
}
