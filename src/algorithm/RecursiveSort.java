package algorithm;

import basic.ListNode;

/**
 * @author kaithy.xu
 * @date 2019/8/6 12:08
 */
public class RecursiveSort {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length < 1){
            return null;
        }

        return merge(lists,0,lists.length-1);
    }

    private ListNode merge(ListNode[] lists,int left,int right){

        if(left >= right){
            return lists[left];
        }
        int center = (left+right)/2;

        ListNode leftNode = merge(lists,left,center);
        ListNode rightNode = merge(lists,center+1,right);

        ListNode temp = new ListNode();
        temp = mergeTwoListNode2(leftNode,rightNode,temp);

        return temp;

    }

    /**
     * 递归合并
     * @param l1
     * @param l2
     * @param temp
     * @return
     */
    private ListNode mergeTwoListNode2(ListNode l1,ListNode l2,ListNode temp){
        if(l1 == null || l2 == null){
            if(l1 == null && l2 == null){
                return l1;
            }else {
                temp = l1 == null ? l2 : l1;
            }

            return temp;
        }

        if(l1.val > l2.val){
            temp = l2;
            temp.next = mergeTwoListNode2(l1,l2.next,temp.next);
        }else {
            temp = l1;

            temp.next = mergeTwoListNode2(l1.next,l2,temp.next);
        }

        return temp;

    }



    public static void main(String[] args){

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);

        ListNode node3 = new ListNode(5);
        node3.next = new ListNode(9);
        node3.next.next = new ListNode(12);
        node3.next.next.next = new ListNode(14);

        ListNode[] list = new ListNode[]{node1,node2,node3};
        RecursiveSort sort = new RecursiveSort();
        ListNode temp = sort.mergeKLists(list);
//        ListNode temp = null;
//        temp = sort.mergeTwoListNode2(node1,node2,temp);
        while (temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
    }

}
