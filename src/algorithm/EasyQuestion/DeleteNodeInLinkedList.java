package algorithm.EasyQuestion;

import basic.ListNode;

/**
 * 删除链表中的节点
 * @author kaithy.xu
 * @date 2019-09-21 17:31
 */
public class DeleteNodeInLinkedList {

    public void deleteNode(ListNode node) {

        while (node.next != null) {
            ListNode temp = node.next;
            node.val = temp.val;
            if(node.next.next == null) {
                node.next = null;
                return;
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int[] nums ={1,2,3,4,5};
        ListNode node = ListNode.acquireListNode(nums,0);
        node = node.next.next;

        new DeleteNodeInLinkedList().deleteNode(node);
        while (node != null) {
            System.out.print(node.val+"-->");
            node = node.next;
        }
    }
}
