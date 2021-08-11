package removeNode;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/8 22:41
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        ListNode ans = removeNode(head, 2);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode removeNode(ListNode head, int i) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        res.next = head;
        while (head.val != i){
            head = head.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return res.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
