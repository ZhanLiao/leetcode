package midOfLinkedList;

import LinkedList.ListNode;

public class Main {
    public static void main(String[] args) {
        System.out.println("=========测试查找链表的中间节点，返回中间节点之后的节点=========");
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);

        Solution solution = new Solution();
        System.out.println(solution.toString(solution.middleNode(head)));
    }
}
