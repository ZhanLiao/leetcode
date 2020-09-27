package orderLinkedToBST;

import tree.TreeNode;

public class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode head, ListNode tail){
        if(head == tail){
            return null;
        }
        ListNode midNode = getMidNode(head, tail);
        TreeNode root = new TreeNode(midNode.val);
        root.left = buildTree(head, midNode);
        root.right = buildTree(midNode.next, tail);

        return root;
    }
    public ListNode getMidNode(ListNode head, ListNode tail){
        ListNode fast, slow;
        fast = head;
        slow = head;

        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
