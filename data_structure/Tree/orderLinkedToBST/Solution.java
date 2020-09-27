package orderLinkedToBST;

import tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<TreeNode> listTreeNode = new LinkedList<TreeNode>();
    TreeNode[] treeNodes;
    public TreeNode sortedListToBST(ListNode head) {
        listNodeTolist(head);
        if(listTreeNode.size() == 0){
            return null;
        }
        treeNodes = listTreeNode.toArray(new TreeNode[listTreeNode.size()]);
        return buildTree(treeNodes, 0, treeNodes.length-1);
    }

    private void listNodeTolist(ListNode head){
        if(head == null){
            return;
        }
        while(head != null){
            listTreeNode.add(new TreeNode(head.val));
            head = head.next;
        }
    }

    private TreeNode buildTree(TreeNode[] treeNodes, int l, int r){
        if(l > r){
            return null;
        }

        int mid = (l + r + 1)/2;
        TreeNode root = treeNodes[mid];
        root.left = buildTree(treeNodes, l, mid-1);
        root.right = buildTree(treeNodes, mid+1, r);
        return root;
    }
}
