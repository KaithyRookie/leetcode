package algorithm.EasyQuestion;

/**
 * 合并两个有序数组
 * @author kaithy.xu
 * @date 2019-09-09 12:06
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i=m-1,j=n-1;
        for (int k = m+n-1; k >=0 ; k--) {
            if(j >= 0 && i>=0) {
                if(nums1[i] < nums2[j]) {
                    nums1[k] = nums2[j--];
                }else {
                    nums1[k] = nums1[i--];
                }
            }else if(i >= 0) {
                nums1[k] = nums1[i--];
            }else {
                nums1[k] = nums2[j--];
            }

        }
    }

    private void merged1(int[] nums, int left, int right) {
        if(left >= right) {

        }
        int middle = left+right >> 1;
        merged1(nums,left,middle);
        merged1(nums,middle+1,right);

    }

    private void merged(int[] nums1,int m,int[] nums2, int n) {
        if(m ==1 && n == 1){

        }
        int left=0,right=0;

        if(m > 0) {
            left = m >> 1;
        }
        if(n > 0){
            right = m >> 1;
        }

        merged(nums1,left,nums2,right);

    }

    public static void main(String[] args) {
        MergeSortedArray sortedArray = new MergeSortedArray();
        System.out.println("the result is ");
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        sortedArray.merge(nums1,1,nums2,1);
        for (int i : nums1) {
            System.out.print(i+",");
        }
    }
}
