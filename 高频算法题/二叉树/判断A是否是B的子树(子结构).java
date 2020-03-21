// 子结构 剑指Offer 26
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean result = false;
        // 当Tree1和Tree2都不为空时才进行比较，否则直接返回false
        if (s != null && t != null) {
            // 如果在Tree1中找到了对应的Tree2的根节点
            if (s.val == t.val) {
                // 在Tree1中以和Tree2中相等的这个节点为根节点开始遍历，判断是否包含Tree2
                result = isSubtreeWithRoot(s, t);
            }
            // 如果找不到，那么就再去s的左子树进行判断，是否包含Tree2
            if (!result) {
                result = isSubtree(s.left, t);
            }
            // 如果还找不到，那么就再去s的右子树进行判断，是否包含Tree2
            if (!result) {
                result = isSubtree(s.right, t);
            }
        }
        return result;
    }

    // 判断Tree1中以s为根节点的树中是否包含Tree2
    public boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        // 如果Tree2都遍历完了，且值能对应上，则说明在Tree1中找到了Tree2
        if (t == null) {
            return true;
        }
        // 如果Tree2还没遍历完，Tree1却遍历完了，则直接返回false
        if (s == null) {
            return false;
        }
        // 如果其中有一个节点没有对应上，返回false
        if (s.val != t.val) {
            return false;
        }
        // 如果根节点对应的上，那么就分别取左右子节点继续进行匹配
        return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
    }
}

// 上面代码的简单写法
public class Solution {
    public boolean isSubtree(TreeNode s,TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
    }
}


// 子树  LeetCode 572
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (t == null || s == null) return false;
        if (t.val != s.val) return false;
        return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
    }
}

// 注意：本题中的TreeNode值类型为int，所以可以使用“==”判断两者是否相等，
// 但是如果val的类型为long时，就不能直接使用“==”去比较了。这是因为在计
// 算机内表示小数时（包括：float和double）都有误差。判断连个小数是否相
// 等，只能判断它们之差的绝对值是不是在一个很小的范围内。如果两个数相差
// 很小，就可以认为它们相等，可以定义一个equal函数：
public boolean equal(double n1, double n2){
    if((ni - n2 > -0.0000001) && (n1 - n2 < 0.0000001)){
        return true;
    }else{
        return false;
    }
}