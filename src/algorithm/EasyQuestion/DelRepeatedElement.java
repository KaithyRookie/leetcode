package algorithm.EasyQuestion;

/**
 * @author kaithy.xu
 * @date 2019-08-27 18:57
 */
public class DelRepeatedElement {
    public int removeDuplicates(int[] nums) {

        int i=0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != nums[i]){
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        DelRepeatedElement element = new DelRepeatedElement();
        System.out.println("the result is "+element.removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+"-->");
        }
    }
}
