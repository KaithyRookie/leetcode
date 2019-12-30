package algorithm;

/**
 * @author kaithy.xu
 * @date 2019/8/5 12:16
 */
public class QuickSort {

    public int findKthLargest(int[] nums, int k){
        if(nums.length < k){
            return 0;
        }
        quickSort(nums,0,nums.length-1,k);

        return nums[k-1];
    }

    private void quickSort(int[] nums,int left,int right,int k){

        int center = (left+right)/2;
        if(left >= right){
            return;
        }
        int pivot = chosePivot(nums,left,right,center);

        int i = left+1;
        int j= right-1;
        while (i < j){
            while (nums[i++] >= nums[center] && i < center){
                i++;
            }
            while (nums[j--] < nums[center] && j > center){
                j--;
            }

            if(nums[i] <= pivot && pivot <= nums[j]){
                swap(nums,i,j);
                if(i == center){
                    center = j;
                }else if(j == center){
                    center = i;
                }
            }
        }
        if(k <= center){
            quickSort(nums,left,center,k);
        }else if(k > center){
            quickSort(nums,center+1,right,k);
        }


    }

    private int chosePivot(int[] nums,int left,int right,int center){

        int numLeft = nums[left];
        int numCen = nums[center];
        int numRig = nums[right];
        if(numRig > numCen){
            swap(nums,right,center);

        }

        if(numLeft < numCen){
            swap(nums,left,center);
        }


        return nums[center];

    }

    private void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    public static void main(String[] args){
        int[] nums = new int[]{3,2,1,5,6,4};

        QuickSort sort = new QuickSort();


        System.out.println(sort.findKthLargest(nums,2));
        for (int i: nums){
            System.out.print(i);
        }
    }


}
