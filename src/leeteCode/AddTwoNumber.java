package leeteCode;

import basic.ListNode;

/**
 * @author kaithy.xu
 * @date 2019/5/22 19:59
 */
public class AddTwoNumber {

    ListNode listNode;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1.val == 0 && l1.next == null ){
            return l2;
        } else if(l2.val == 0 && l2.next == null){
            return l1;
        }

        ListNode tempNode = null;

        ListNode resultNode = null;

        boolean isAddOne = false;

        while (l1 != null && l2 != null){

            int sum = (l1.val + l2.val)%10;
            if(isAddOne){
                sum = sum+1;
                if((sum/10) >0){
                    sum = sum%10;
                    isAddOne = true;
                }else {
                    isAddOne = false;
                }
            }
            if(tempNode == null){
                tempNode = new ListNode(sum);
                resultNode = tempNode;
            }else {

                tempNode.next = new ListNode(sum);
            }
            if((l1.val+l2.val)/10 > 0){
                isAddOne = true;
            }

            l1 = l1.next;
            l2 = l2.next;
            if(tempNode.next != null) {
                tempNode = tempNode.next;
            }
        }
        
        if(l1 != null){

            while (l1 != null){
                int sum =l1.val;
                if (isAddOne){
                    sum = sum+1;
                    if((sum)/10 > 0){
                        sum = sum%10;
                        isAddOne = true;
                    }else {
                        isAddOne = false;
                    }
                }
                l1 = l1.next;
                tempNode.next = new ListNode(sum);
                tempNode = tempNode.next;
            }
        }else if(l2 != null) {

            while (l2 != null){
                int sum =l2.val;
                if (isAddOne){
                    sum = sum+1;
                    if((sum)/10 > 0){
                        sum = sum%10;
                        isAddOne = true;
                    }else {
                        isAddOne = false;
                    }
                }
                l2 = l2.next;
                tempNode.next = new ListNode(sum);
                tempNode = tempNode.next;
            }
            
        }

        if(isAddOne){
            tempNode.next = new ListNode(1);
            tempNode = tempNode.next;
        }

        return resultNode;
    }
    
    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        AddTwoNumber addTwoNumber = new AddTwoNumber();

        ListNode listNode = addTwoNumber.addTwoNumbers(l1,l2);

        while (listNode != null){
            System.out.println(listNode.val+"-->");
            listNode = listNode.next;
        }

    }
}
