package findKMaxBST;

import tree.TreeNode;

import java.util.ArrayList;

public class Solution {
    public int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inOrder(root, list);
        return list.get(list.size() - k);
    }

    private void inOrder(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
