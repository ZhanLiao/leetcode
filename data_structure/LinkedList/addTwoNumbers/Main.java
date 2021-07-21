package addTwoNumbers;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/8 21:56
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(4);

        ListNode ans = addTwoNumbers(l1, l2);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }

    }

    private static ListNode addTwoNumbers(ListNode p, ListNode q) {
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (p != null || q != null){
            int a = p != null ? p.val : 0;
            int b = q != null ? q.val : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0){
            cur.next = new ListNode(carry);
        }
        return res.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }


}
