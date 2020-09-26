package orderArrayToBalenceTree;

import tree.TreeNode;

/**
 * 有序的数组就是二叉搜索树的中序遍历，但是所得树并不是唯一的
 * 要满足左右子树的高度不大于1，父节点应该取有序数组的中间数。使得左右子树的个数相差不大于1。
 *
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return doBalence(nums, 0, nums.length-1);
    }

    private TreeNode doBalence(int[] nums, int l, int r){
        if(l > r){
            return null;
        }

        int mid = (l + r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = doBalence(nums, l, mid-1);
        root.right = doBalence(nums, mid+1, r);
        return root;
    }
}