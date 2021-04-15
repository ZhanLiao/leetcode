package reversList;

import LinkedList.ListNode;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/4/14 16:32
 * @Version: 1.0
 */
public class Solution {
    public ListNode ReverseList(ListNode head){
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
