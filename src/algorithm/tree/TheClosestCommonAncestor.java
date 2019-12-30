package algorithm.tree;

import basic.TreeNode;

/**
 * @author kaithy.xu
 * @date 2019-08-15 18:22
 */
public class TheClosestCommonAncestor {

    private TreeNode record = null;

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){

        if(p.val > q.val){
            acquireAncestor(root,q,p);
        }else {
            acquireAncestor(root,p,q);
        }
        return record;

    }

    private void acquireAncestor(TreeNode root, TreeNode min, TreeNode max){
        if(root == null){
            return;
        }
        if(root.val >= min.val && root.val <= max.val){ // 若 root 在 min与max中间，就是要找的最近公共祖先
            record = root;
        }else if(root.val < min.val){ // 若root 比 min 还要小，那说明给定节点在root节点的右侧
            acquireAncestor(root.right,min,max);
        }else {
            acquireAncestor(root.left,min,max);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6,2,8,1,4,7,9,0,-1,3,5};
        TreeNode root = TreeNode.makeTree(nums,0);

        TreeNode p = new TreeNode(8);
        TreeNode q = new TreeNode(2);

        TheClosestCommonAncestor ancestor = new TheClosestCommonAncestor();
        System.out.println("the closest ancestor is "+ancestor.lowestCommonAncestor2(root,p,q).val);
    }
}
