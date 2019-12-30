package algorithm.MiddleQuestion;

/**
 * @author kaithy.xu
 * @date 2019-09-10 18:52
 */
public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int leftEle = 1, rightEle = 1;
        for (int i = 0; i < nums.length; i++) {
            left[i] = leftEle;
            leftEle *= nums[i];
        }
        for (int i = nums.length-1; i >= 0 ; i--) {
            right[i] = rightEle;
            rightEle *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            left[i] = left[i] * right[i];
        }
        return left;
    }

    /**
     * 常数级的空间复杂度
     * @param nums
     * @return
     */
    public int[] solution(int[] nums) {
        int[] result = new int[nums.length];
        int right = 1;
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        for (int i = nums.length-1; i >= 0 ; i--) {

            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result = new ProductofArrayExceptSelf().solution(nums);
        System.out.println("the result is :");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+",");
        }
    }
}
