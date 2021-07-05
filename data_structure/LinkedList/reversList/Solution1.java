package reversList;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/1 21:15
 * @Version: 1.0
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
