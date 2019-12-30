package algorithm.MiddleQuestion;

import basic.ListNode;

/**
 * 旋转链表
 * @author kaithy.xu
 * @date 2019-09-11 18:33
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        int length = 0;
        ListNode record = head;
        while (record.next != null) {
            length ++;
            record = record.next;
        }
        ++length;

        k %= length;
        if(k == 0) {
            return head;
        }
        record.next = head;
        //second 从 1开始遍历到length-k 效果与从0开始遍历到length-k-1是一样的
        int second=1;
        ListNode cursor = head;
        while (second < length - k) {
            cursor = cursor.next;
            ++second;
        }
        //保留头节点
        ListNode temp = cursor.next;
        //头尾节点分离
        cursor.next = null;
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        ListNode head = ListNode.acquireListNode(nums,0);

        ListNode result = new RotateList().rotateRight(head,2);

        System.out.println("the result is:");

        while (result != null) {
            System.out.print(result.val+"-->");
            result = result.next;
        }
    }
}
