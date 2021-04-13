package findKMaxBST;

import tree.TreeNode;


public class Solution2 {

    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.right);
        if (k == 0){
            return;
        }
        if (--k == 0){
            res = root.val;
        }
        inOrder(root.left);

    }
}
