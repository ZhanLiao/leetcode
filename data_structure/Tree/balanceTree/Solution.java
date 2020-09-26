package balanceTree;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 有序的数组就是二叉搜索树的中序遍历，但是所得树并不是唯一的
 * 要满足左右子树的高度不大于1，父节点应该取有序数组的中间数。使得左右子树的个数相差不大于1。
 *
 */
class Solution {
    List<TreeNode> list = new LinkedList<TreeNode>();
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        TreeNode[] sortedNodes = new TreeNode[list.size()];
        if(list.size() < 3){
            return root;
        }

        sortedNodes = list.toArray(sortedNodes);
        return doBalence(sortedNodes, 0, list.size()-1);
    }

    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        list.add(root.left);
        inOrder(root.right);
    }

    private TreeNode doBalence(TreeNode[] sortedNodes, int l, int r){
        if(l > r){
            return null;
        }

        int mid = (l + r)/2;
        TreeNode root = sortedNodes[mid];
        root.left = doBalence(sortedNodes, l, mid-1);
        root.right = doBalence(sortedNodes, mid+1, r);
        return root;
    }
}