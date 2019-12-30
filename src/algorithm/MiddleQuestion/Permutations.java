package algorithm.MiddleQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * @author kaithy.xu
 * @date 2019-10-01 23:24
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();

        List<Integer> numLists = new ArrayList<>();
        for (Integer num : nums) {
            numLists.add(num);
        }

        traceBack(nums.length,numLists,result,0);
        return result;
    }

    private void traceBack(int total, List<Integer> nums, List<List<Integer>> result,int first) {
        if(first == total) {
            result.add(new ArrayList<>(nums));
        }

        for (int i = first; i < total; i++) {
            Collections.swap(nums, first, i);
            traceBack(total,nums,result,first+1);
            Collections.swap(nums,first,i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println("the result is "+new Permutations().permute(nums));
    }
}
