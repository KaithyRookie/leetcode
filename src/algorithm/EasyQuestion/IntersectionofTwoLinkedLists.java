package algorithm.EasyQuestion;

import basic.ListNode;

/**
 * 相交链表
 * @author kaithy.xu
 * @date 2019-09-18 12:02
 */
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        if(headA == headB) {
            return headA;
        }
        ListNode recordA = headA;
        ListNode recordB = headB;
        int lengthA = 0,lengthB=0;
        while (recordA.next != null) {
            ++lengthA;
            recordA = recordA.next;
        }
        while (recordB.next != null) {
            ++lengthB;
            recordB = recordB.next;
        }
        if(recordA != recordB) {
            return null;
        }
        int sub = lengthA - lengthB;
        if(sub > 0) {
            while (sub > 0) {
                headA = headA.next;
                --sub;
            }
        }else if(sub < 0) {
            while (sub < 0) {
                headB = headB.next;
                ++sub;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static void main(String[] args) {
        int[] numsA = {4,1,8,4,5};
        int[] numsB = {5,0,1};
        int a=2,b=3;
        ListNode headA = ListNode.acquireListNode(numsA,0);
        ListNode headB = ListNode.acquireListNode(numsB,0);
        ListNode recordA = headA;
        ListNode recordB = headB;
        while (a > 0) {
            --a;
            recordA = recordA.next;
        }
        while (b >1) {
            --b;
            recordB = recordB.next;
        }
        recordB.next = recordA;
        System.out.println("the result is "+new IntersectionofTwoLinkedLists().getIntersectionNode(headA,headB));
    }
}
