package algorithm.tree;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kaithy.xu
 * @date 2019-08-14 12:05
 */
public class TheMinKElement {

    int record = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
         find(root,k);
        return result;
    }

    private void find(TreeNode root, int k){

        if(root == null){
            return ;
        }

        find(root.left,k);
        record++;
        if(k == record){
            result = root.val;
            return ;
        }
        find(root.right,k);
        return ;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{5};
//        TreeNode node = TreeNode.makeTree(nums,0);
//
//        TheMinKElement min = new TheMinKElement();
//        System.out.println("the result is: "+min.kthSmallest(node,1));

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        System.out.println("before");
        list.forEach(i ->System.out.println(i));

        list.forEach(i->i=i+2);
        System.out.println("after");
        list.forEach(i ->System.out.println(i));

        System.out.println("before");
        list.stream().forEach(i->System.out.println(i));

        list.stream().forEach(i->i=i+2);
        System.out.println("after");
        list.stream().forEach(i->System.out.println(i));
    }
}
