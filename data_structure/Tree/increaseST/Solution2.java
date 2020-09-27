package increaseST;

import tree.TreeNode;

/**
 * 解法二：在中序遍历的时候，就对当前节点进行操作，省去通过链表再次遍历构造树。
 */
public class Solution2 {
    TreeNode curNode;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        curNode = ans;
        inOrder(root);
        return ans.right;
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        curNode.left = null;
        curNode.right = root;
        curNode = curNode.right;
        inOrder(root.right);
    }
}
