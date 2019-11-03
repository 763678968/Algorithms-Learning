public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) { // 如果有右子树，则找右子树的最左节点
            pNode = pNode.right;
            while (pNode.left != null) pNode = pNode.left;
            return pNode;
        }
        // pNode.next为指向父节点的指针
        while (pNode.next != null) { // 如果没有右子树，则向上找是父节点左孩子的节点，这个节点的父节点即为所求的“下一个节点”
            if (pNode.next.left == pNode) return pNode.next; // 如果该节点是父节点的左子树，直接返回
            pNode = pNode.next; // 如果该节点不是左节点，就向上查找
        }
        return null; // 退到了根节点仍没找到，则返回null
    }
}
