package algorithm.MiddleQuestion;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *不允许使用除法
 *
 * 题解：
 * 用左右数组L 和 R，分别保存位置i 左侧的乘积以及 右侧的乘积
 * 其中 L[0] 与 R[length-1] 为 1
 * 因为 L[1] = 1 * nums[0] = L[0] * nums[0]
 * L[2] = 1 * nums[1] * nums[0] = nums[1] * L[1]
 * 依次类推： L[i] = nums[i-1] * L[i-1]
 *
 * 同理
 * R[i] = R[i+1] * nums[i+1]
 *
 * 空间复杂度O(2N) = O(N)
 *
 * @author kaithy.xu
 * @date 2020-06-04 20:47
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] result = new int[length];
        int[] L = new int[length];
        int[] R = new int[length];

        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = L[i-1] * nums[i-1];
        }

        R[length-1] = 1;
        for (int i = length-2; i >= 0; i--) {
            R[i] = R[i+1] * nums[i+1];
        }

        for (int i = 0; i < length; i++) {
            result[i] = L[i]*R[i];
        }

        return result;

    }


    public static void main(String[] args) {
        ProductExceptSelf self = new ProductExceptSelf();
        int[] nums = new int[]{0,0,3,4};

        int[] result = self.productExceptSelf(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+"\t");
        }
    }
}
