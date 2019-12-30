package algorithm;


import basic.TreeNode;

/**
 * @author kaithy.xu
 * @date 2019-08-12 18:46
 */
public class MaxDepthOfTree {

    private int depth = 0;
    public int maxDepth(TreeNode root) {
        acquireDepth(root,0);
        return depth;
    }

    private int acquireDepth(TreeNode root,int i){
        if(root == null){
            return i;
        }
        i++;
        acquireDepth(root.left,i);
        acquireDepth(root.right,i);
        depth = Math.max(depth,i);
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,9,20,-1,-1,15,7};
        TreeNode treeNode = TreeNode.makeTree(nums,0);

        MaxDepthOfTree tree = new MaxDepthOfTree();
        System.out.println("the max depth is "+tree.maxDepth(treeNode));
    }
}
