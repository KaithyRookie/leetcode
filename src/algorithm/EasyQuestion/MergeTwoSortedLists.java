package algorithm.EasyQuestion;

import basic.ListNode;

/**
 * @author kaithy.xu
 * @date 2019-09-11 12:19
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode merged = merged(l1,l2,null);
        return merged;
    }

    private ListNode merged(ListNode l1, ListNode l2, ListNode result) {
        if(l1 == null && l2 == null) {
            return null;
        }else if(l1 == null) {
            return l2;
        }else if(l2 == null) {
            return l1;
        }
        if( l1.val < l2.val) {
            result = l1;
            result.next = merged(l1.next,l2,result.next);
        }else {
            result = l2;
            result.next = merged(l1,l2.next,result.next);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,2,4,5};
        int[] nums2 = {1,3};
        ListNode l1 = ListNode.acquireListNode(nums1,0);
        ListNode l2 = ListNode.acquireListNode(nums2,0);

        ListNode result = new MergeTwoSortedLists().mergeTwoLists(l1, l2);

        System.out.println("the result is :");
        while (result != null) {
            System.out.print(result.val+"-->");
            result = result.next;
        }
    }

}
