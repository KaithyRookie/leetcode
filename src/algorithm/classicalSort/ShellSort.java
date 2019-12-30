package algorithm.classicalSort;

/**
 * @author kaithy.xu
 * @date 2019-09-03 19:27
 */
public class ShellSort {

    public static void shellSort(int[] nums) {

        int length = nums.length;
        int leftIndex;
        for (int gap = length >> 1; gap >= 0 ; gap /= 2) {
            for (int rightIndex = gap; gap < length; rightIndex++){
                int temp = nums[rightIndex];
                for (leftIndex = rightIndex; leftIndex >= gap && temp < nums[leftIndex-gap] ; leftIndex -= gap) {
                    nums[leftIndex] = nums[leftIndex-gap];
                }
                nums[leftIndex] = temp;
            }

        }
    }
}
