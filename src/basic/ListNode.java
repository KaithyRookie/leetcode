package basic;

/**
 * @author kaithy.xu
 * @date 2019/5/22 20:00
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {

        val = x;
    }

    public ListNode(){

    }
    
    public static ListNode acquireListNode(int[] elements,int index){
        
        if(index>=elements.length){
            return null;
        }
        ListNode node = new ListNode(elements[index++]);
        node.next =  acquireListNode(elements,index);
        return node;
    }
    
    
    public static void main(String[] args){
        int[] nums = new int[]{4,1,2,3};

        ListNode node = acquireListNode(nums,0);

        while (node != null){
            System.out.println(node.val+"-->");
            node = node.next;

        }

    }
}

