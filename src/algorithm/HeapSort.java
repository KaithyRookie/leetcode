package algorithm;

/**
 * @author kaithy.xu
 * @date 2019/8/5 22:02
 */
public class HeapSort {

    public int findKthLargest(int[] nums, int k){

        for (int i=0; i <nums.length; i++){
            if(i < k){
                heaplify(nums,k-1,i);

            }else {

                if(nums[0] < nums[i]){
                    nums[0] = nums[i];
                    heaplify(nums,k-1,0);
                }
            }
        }
        return nums[0];

    }

    private void heaplify(int[] nums,int n,int i){

        while (true){
            int minPos = i;
            if(i*2 <= n && nums[i] > nums[i*2]){
                minPos = 2*i;
            }
            if((i*2+1) <= n && nums[minPos] > nums[i*2+1]){
                minPos = 2*i+1;
            }

            if(minPos == i){
                break;
            }
            swap(nums,i,minPos);
            i = minPos;
        }
    }

    private void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,2,1,5,6,4};

        HeapSort sort = new HeapSort();

        System.out.println(sort.findKthLargest(nums,2));
        for (int i: nums){
            System.out.print(i);
        }
    }
}
