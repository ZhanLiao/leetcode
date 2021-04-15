package midOfLinkedList;

import LinkedList.ListNode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=========测试查找链表的中间节点，返回中间节点之后的节点=========");
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);

        ListNode cur = new ListNode(0);
        ListNode dummy = cur;
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.replace(" ", "");
        System.out.println(str);
        for (int i = 0; i < str.length(); i++) {
            cur.next = new ListNode(str.charAt(i) - '0');
            cur = cur.next;
        }
        ListNode h = dummy.next;
        Solution solution = new Solution();
//        System.out.println(solution.toString(solution.middleNode(head)));
        System.out.println(solution.toString(solution.middleNode(h)));
    }
}
