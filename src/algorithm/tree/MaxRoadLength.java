package algorithm.tree;

import basic.TreeNode;

/**
 * @author kaithy.xu
 * @date 2019-08-13 18:27
 */
public class MaxRoadLength {

    private int num = 0;
    public int maxPathSum(TreeNode root) {

        num = root.val;
        calculate(root);
        return num;
    }

    private int calculate(TreeNode root){

        if(root == null){
            return 0;
        }
        int leftLength = Math.max(0,calculate(root.left));
        int rightLength = Math.max(0,calculate(root.right));

        num = Math.max(num,root.val+leftLength+rightLength);
        return Math.max(leftLength,rightLength)+root.val;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};

        TreeNode node = TreeNode.makeTree(nums,0);
//        TreeNode node = new TreeNode(-2);
//        node.left = new TreeNode(-1);
        MaxRoadLength length = new MaxRoadLength();

        System.out.println("the max roal length is :"+length.maxPathSum(node));
    }
}
