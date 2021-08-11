package contest01;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/18 19:42
 * @Version: 1.0
 */
public class Main04 {
    public static void main(String[] args) {

        ListNode linkedNode = new ListNode(1);
        linkedNode.next = new ListNode(2);
        linkedNode.next.next = new ListNode(3);
        linkedNode.next.next.next = new ListNode(4);
        linkedNode.next.next.next.next = linkedNode.next;
        ListNode post = deal(linkedNode);
        System.out.println(post.val);


    }

    private static ListNode deal(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode(){

    }

    public ListNode(int temp) {
        this.val = temp;
    }
}

