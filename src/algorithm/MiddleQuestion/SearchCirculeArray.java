package algorithm.MiddleQuestion;

/**
 * @author kaithy.xu
 * @date 2019-09-04 12:09
 */
public class SearchCirculeArray {
    private int searched = -1;
    public int search(int[] nums, int target) {
        if(nums.length < 1){
            return searched;
        }
        boolean[] visited = new boolean[nums.length];
        quickSort(nums,0,nums.length-1,target,visited);
        return searched;
    }

    private void quickSort(int[] nums, int left,int right, int target,boolean[] visited) {
        if(searched != -1){
            return ;
        }
        if(visited[left]  && visited[right] ){
            return;
        }

        int middle = left+right >> 1;
        if(nums[left] == target){
            searched = left;
        }else if(nums[right] == target){
            searched = right;
        }
        if(left >= right){
            return;
        }

        visited[left] = true;
        visited[right] = true;
        quickSort(nums,left,middle,target,visited);
        quickSort(nums,middle+1,right,target,visited);
    }

    public int bestSolution(int[] nums, int target) {
        if(nums.length < 1){
            return -1;
        }
        int left = 0,right=nums.length-1;

        while (left < right){
            int middle = left+right >> 1;
            //根据题意，升序的数组旋转后，最小点一定小于数组的最后一个元素
            if(nums[middle] < nums[nums.length - 1]){
                right = middle;
            }else {
                //若middle 比 最后一个元素大，说明前middle个元素是升序状态
                left = middle+1;
            }
        }
        if(target == nums[right]){
            return right;
        }

        if(target > nums[nums.length-1]) {
            search(nums,0,right-1,target);
        }else {
            search(nums,right,nums.length-1,target);
        }

        return searched;
    }

    private void search(int[] nums, int left, int right,int target) {
        if(left > right){
            return ;
        }
        int middle = left + right >> 1;
        if(nums[middle] > target){
            search(nums,left,middle-1,target);
        }else if(nums[middle] < target){
            search(nums,middle+1,right,target);
        }else {
            searched = middle;
        }
        return ;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,0,1,2};
        int target = 1;
        System.out.println("the result is "+new SearchCirculeArray().bestSolution(nums,target));
    }

}
