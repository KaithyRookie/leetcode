package algorithm.tree;

import basic.TreeNode;

/**
 * @author kaithy.xu
 * @date 2019-08-16 12:03
 */
public class BinaryTreeClosestCommonAncestor {


    TreeNode record = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        commonEntrance(root,p,q);
        return record;
    }

    private void commonEntrance(TreeNode root, TreeNode p, TreeNode q){

        if(root == null){
            return;
        }
        Integer left = findAncestorLeftTree(root.left,p,q);
        Integer right = findAncestorRightTree(root.right,p,q);
        if(left != null && right != null){
            record = root;
        }else if(left == null){
            if(right != null){
                record = root.right;
            }
            lowestCommonAncestor(root.right,p,q);
        }else if(right == null){
            if(left != null){
                record = root.left;
            }
            lowestCommonAncestor(root.left,p,q);
        }
    }

    private Integer findAncestorLeftTree(TreeNode root, TreeNode p, TreeNode q){
        Integer left = null;
        if(root == null){
            return null;
        }
        if(root.val == p.val || root.val == q.val){
            if(left == null){
                left = root.val;
                return left;
            }
        }
        if(left == null){
            left = findAncestorLeftTree(root.left,p,q);
        }
        if(left == null){
            left = findAncestorLeftTree(root.right,p,q);
        }

        return left;
    }

    private Integer findAncestorRightTree(TreeNode root, TreeNode p, TreeNode q){
        Integer right = null;
        if(root == null){
            return null;
        }
        if(root.val == p.val || root.val == q.val){
            if(right == null){
                right = root.val;
                return right;
            }
        }
        if(right == null) {
            right = findAncestorRightTree(root.right, p, q);
        }
        if(right == null) {
            right = findAncestorRightTree(root.left, p, q);
        }
        return right;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return root;
        }
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left,p,q);
        TreeNode right = lowestCommonAncestor2(root.right,p,q);

        if(left != null && right != null){
            return root;
        }else if(left != null){
            return left;
        }else if(right != null){
            return right;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{37,-34,-48,-1,-100,-101,48,-1,-1,-1,-1,-54,-1,-71,-22,-1,-1,-1,8};
        TreeNode root = TreeNode.makeTree(nums,0);

        TreeNode p = new TreeNode(-100);
        TreeNode q = new TreeNode(48);

        BinaryTreeClosestCommonAncestor ancestor = new BinaryTreeClosestCommonAncestor();

        System.out.println("the closest ancestor is: "+ancestor.lowestCommonAncestor2(root,p,q).val);
    }
}
//[37,-34,-48,null,-100,-101,48,null,null,null,null,-54,null,-71,-22,null,null,null,8]
//-71
//48