package algorithm.MiddleQuestion;

import basic.ListNode;

/**
 *
 * 环形链表II
 * @author kaithy.xu
 * @date 2019-09-17 18:24
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if(fast == null) {
                return null;
            }
            fast = fast.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null) {
            return null;
        }
        ListNode record = head;
        while (record != slow) {
            slow = slow.next;
            record = record.next;
        }
        return record;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,0,-4};
        int pos = 0;
        ListNode head = ListNode.acquireListNode(nums,0);
        ListNode tail = head;
        if(pos >= 0) {
            while (tail.next != null) {
                tail = tail.next;
            }
            ListNode temp = head;
            for (int i = 0; i < pos; i++) {
                temp = temp.next;
            }
            tail.next = temp;
        }

        System.out.println("the result is "+new LinkedListCycleII().detectCycle(head).val);
    }
}
