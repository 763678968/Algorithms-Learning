public class Solution {
     private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
     private ArrayList<Integer> list = new ArrayList<Integer>();

     public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
         if (root == null) return listAll;
         list.add(root.val);
         target -= root.val;
         // target等于0，表示路径上的元素和为target
         // 题目要求到“叶节点”所经过的节点形成的路径，所以判断root的左右节点是否为null
         if (target == 0 && root.left == null && root.right == null)
             listAll.add(new ArrayList<Integer>(list));
         FindPath(root.left, target);
         FindPath(root.right, target);
         // 移除最后一个元素
         list.remove(list.size() - 1);
         return listAll;
    }
}
