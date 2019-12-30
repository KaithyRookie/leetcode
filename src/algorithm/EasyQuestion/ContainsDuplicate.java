package algorithm.EasyQuestion;

/**
 * @author kaithy.xu
 * @date 2019-09-09 18:49
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 1) {
            return false;
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int hash = (Math.abs(nums[i])+length) % length;
            if(hash != i+1) {
                if(hash > 0) {
                    --hash;
                }
                if((nums[hash] ^ nums[i]) == 0) {
                    return true;
                }
                int temp = nums[i];
                nums[i] = nums[hash];
                nums[hash] = temp;
            }
        }
        return false;
    }

    private void search(int[] nums, int left, int right) {

        if(left >= right){

        }
        int middle = left+right >> 1;

        search(nums,left,middle);
        search(nums,middle+1,right);
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println("the result is:"+new ContainsDuplicate().containsDuplicate(nums));
    }
}
