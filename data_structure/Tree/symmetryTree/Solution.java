package symmetryTree;

import tree.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }else {
            return check(root.left, root.right);
        }
    }

    public boolean check(TreeNode L, TreeNode R){
        if(L == null && R == null){
            return true;
        }
        if(L == null || R ==null){
            return false;
        }
        return L.val == R.val && check(L.left, R.right) && check(L.right, R.left);
    }
}
