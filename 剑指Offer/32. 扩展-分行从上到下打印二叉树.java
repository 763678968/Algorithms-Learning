import java.util.ArrayList;

public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null)
            return result;
        
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        queue.add(pRoot);
        int start = 0, end = 1;
        
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove(0);
            list.add(temp.val);
            start++;
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
            if (start == end) {
                end = queue.size();
                start = 0;
                result.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return result;
    }  
}
