package algorithm.EasyQuestion;

/**
 * 最大子序和
 * @author kaithy.xu
 * @date 2019-08-29 19:03
 */
public class LargestChildSerAdditive {
    public int maxSubArray(int[] nums) {

        int result = nums[0],sum=nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i],nums[i]+sum);
            result = Math.max(result,sum);
        }
        return result;
    }

    /**
     * 利用分治的思想
     * @param nums
     * @return
     */
    public int solution(int[] nums){
        return searchAndAdd(nums,0,nums.length-1);
    }

    private int searchAndAdd(int[] nums, int left,int right){
        if(left >= right){
            return nums[left];
        }
        int middle = left+right >> 1;
        int leftNum = searchAndAdd(nums,left,middle);
        int rightNum = searchAndAdd(nums,middle+1,right);
        int mergeNUm = merge(nums, left, middle, right);
        return Math.max(Math.max(leftNum,rightNum),mergeNUm);
    }

    /**
     * 合并操作时找到左右两部分合并后的最大值
     * @param nums
     * @param low
     * @param middle
     * @param high
     * @return
     */
    private int merge(int[] nums, int low, int middle, int high) {

        int temp = 0,result=nums[low];
        int k;
        while ((k=middle+1) <= high){

        }
        for (int i = low; i <= high; i++) {
            temp = Math.max(nums[i],nums[i]+temp);
            result = Math.max(result,temp);
        }
        return result;
    }

    public static void main(String[] args) {
        LargestChildSerAdditive additive = new LargestChildSerAdditive();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println("the result is "+additive.solution(nums));
    }
}
