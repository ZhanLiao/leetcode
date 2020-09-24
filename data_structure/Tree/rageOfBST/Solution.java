package rageOfBST;

import Tree.TreeNode;

public class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int ans = 0;
        ans = subSumBST(root, L, R);
        return ans;
    }
    private int subSumBST(TreeNode root, int L, int R){
        if (root == null){
            return 0;
        }
        if (root.val > R){  // 当前节点值大于有界限值，超出右界限值，说明应该去左子树找。
            return subSumBST(root.left, L, R);
        }
        if (root.val < L){  // 当前节点值小于有界限值，超出左界限值，说明应该去右子树找。
            return subSumBST(root.right, L, R);
        }
        return root.val + subSumBST(root.right, L, R) + subSumBST(root.left, L, R);
    }

}
