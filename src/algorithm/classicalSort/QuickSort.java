package algorithm.classicalSort;

/**
 * @author kaithy.xu
 * @date 2019-09-01 20:28
 */
public class QuickSort {
    public void sortNums(int[] nums, int left, int right) {
        if(left >= right){
            return;
        }
        int middle = left+right >> 1;
        int pivot = median(nums, left, right);
        int first = left, last=right;
        while (first < last) {
            while ( nums[++first] < pivot) {}
            while ( nums[--last] > pivot) {}
            if(first < last) {
                swap(nums,first,last);
            }
        }
        if(left < right-1){
            swap(nums, first, right-1);
        }

        sortNums(nums, left, middle-1);
        sortNums(nums, middle+1, right);
    }

    private int median(int[] nums,int left,int right) {
        int middle = (left+right) >> 1;
        if(nums[left] >= nums[right]){
            swap(nums, left, right);
        }
        if(nums[middle] <= nums[left]){
            swap(nums,middle,left);
        }
        if(nums[middle] >= nums[right]){
            swap(nums,middle,right);
        }

        swap(nums,middle,right-1);
        return nums[right-1];
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;

    }

    public static void main(String[] args) {
        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        QuickSort quickSort = new QuickSort();
        quickSort.sortNums(nums,0,nums.length-1);
        System.out.println("after sotred nums is");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+", ");
        }
    }
}
