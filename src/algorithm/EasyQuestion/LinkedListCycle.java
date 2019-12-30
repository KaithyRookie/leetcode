package algorithm.EasyQuestion;

import basic.ListNode;

/**
 * @author kaithy.xu
 * @date 2019-09-16 12:27
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if(fast != null) {
                fast = fast.next;
            }else {
                return false;
            }
            if(fast != null) {
                fast = fast.next;
            }
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int pos = -1;
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


        System.out.println("the result is "+new LinkedListCycle().hasCycle(head));
    }
}
