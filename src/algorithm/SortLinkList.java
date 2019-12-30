package algorithm;

import basic.ListNode;

/**
 * @author kaithy.xu
 * @date 2019/8/9 12:18
 */
public class SortLinkList {

    public ListNode sortList(ListNode head) {

        return sort(head,null);
    }


    private ListNode sort(ListNode head,ListNode middle) {

        if(head == null && middle == null){
            return null;
        }
        if(head == middle){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast != middle && fast.next != middle){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode r = sort(slow.next,middle);

        slow.next = null;
        ListNode l = sort(head,slow);

        return merge(l,r);
    }

    private ListNode merge(ListNode left ,ListNode right){

        ListNode temp = new ListNode(0);
        ListNode record = temp;
        while (left != null && right!= null){
            if(left.val < right.val){
                record.next = left;
                left = left.next;

            }else {
                record.next = right;
                right = right.next;
            }
            record = record.next;
        }
        if(left != null){
            record.next = left;
        }else if(right!= null){
            record.next = right;
        }
        return temp.next;
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,4,3,1,2,5};

        SortLinkList sortLinkList = new SortLinkList();
        ListNode node = ListNode.acquireListNode(nums,0);
        ListNode node2 = sortLinkList.sortList(node);

        while (node2 != null){
            System.out.print(node2.val+"-->");
            node2 = node2.next;
        }
    }

}
