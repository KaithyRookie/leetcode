package algorithm.EasyQuestion;

import basic.ListNode;

/**
 * 反转链表
 * @author kaithy.xu
 * @date 2019-09-19 12:06
 */
public class ReverseLinkedList {

    ListNode node;
    public ListNode reverseList(ListNode head) {
        if(null == head) {
            return null;
        }
        reverse(head);
        return node;
    }

    private ListNode reverse(ListNode head) {
        if(null == head.next) {
            node = head;
            return head;
        }
        ListNode nextNode = reverse(head.next);
        nextNode.next = head;
        head.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.acquireListNode(nums,0);
        ListNode result = new ReverseLinkedList().reverseList(head);

        while (result != null) {
            System.out.print(result.val+"-->");
            result = result.next;
        }
    }
}
