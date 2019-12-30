package algorithm.MiddleQuestion;

import algorithm.classicalSort.QuickSort;

import java.util.Arrays;
import java.util.Map;

/**
 * @author kaithy.xu
 * @date 2019-09-02 19:00
 */
public class MostCloseThreeSum {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int maxSum = nums[0]+nums[nums.length-1]+nums[1] - target;
        for (int i = 0; i < nums.length-2; i++) {
            int head = i+1,tail = nums.length-1;
            while (head < tail){
                int tempSum = nums[i] + nums[head] + nums[tail] - target;
                if(Math.abs(tempSum) < Math.abs(maxSum)){
                    maxSum = tempSum;
                }
                if(tempSum == 0) {
                    return tempSum+target;
                }else if(tempSum < 0){
                    head++;
                }else {
                    tail--;
                }

            }
        }
        return maxSum+target;
    }

    public static void main(String[] args) {
        MostCloseThreeSum threeSum = new MostCloseThreeSum();
        int[] nums = {1, 1, -1, -1, 3};

        System.out.println("the result is "+threeSum.threeSumClosest(nums,-1));
    }
}
