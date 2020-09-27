package midOfLinkedList;


import LinkedList.ListNode;

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow, fast;
        slow = head;
        fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public String toString(ListNode midNode) {
        StringBuffer stringBuffer = new StringBuffer();
        while (midNode != null){
            stringBuffer.append(midNode.val);
            midNode = midNode.next;
        }
        return stringBuffer.toString();
    }
}
