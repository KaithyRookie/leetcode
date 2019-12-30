package basic;

/**
 * @author kaithy.xu
 * @date 2019-08-12 18:47
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode makeTree(int[] nums,int index){

        if(index >= nums.length || nums[index] == -1){
            return null;
        }
        TreeNode root = new TreeNode(nums[index]);

        root.left = makeTree(nums,index*2+1);
        root.right = makeTree(nums,index*2+2);
        return root;
    }

    public static void showTree(TreeNode treeNode){

        if(treeNode == null){
            System.out.println("null");
            return;
        }
        System.out.println(treeNode.val+"-->");
        showTree(treeNode.left);
        showTree(treeNode.right);

    }

    public static void showTreeByMiddle(TreeNode treeNode){

        if(treeNode == null){
            System.out.println("null");
            return;
        }
        showTree(treeNode.left);
        System.out.println(treeNode.val+"-->");
        showTree(treeNode.right);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        TreeNode treeNode = makeTree(nums,0);
        showTree(treeNode);
    }
}
