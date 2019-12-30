package algorithm.MiddleQuestion;

import java.util.*;

/**
 * @author kaithy.xu
 * @date 2019-08-29 18:30
 */
public class ResultOfAddingTreeNum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
//        sortNums(nums); //利用自己实现的希尔排序算法对数组进行排序
        Arrays.sort(nums); //系统自带的排序算法
        for (int i = 0; i < nums.length-2; ++i) {
            if(i == 0 || nums[i] != nums[i-1]){
                int first = i+1, last = nums.length-1;
                while (first < last){
                    int sum = nums[first] + nums[last] + nums[i];
                    if(sum == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[first]);
                        list.add(nums[last]);
                        resultList.add(list);
                        while (first < last && nums[++first] == nums[first-1]){}
                        while (first < last && nums[--last] == nums[last+1]){}

                    }else {
                        if(sum > 0){
                            while (nums[--last] == nums[last+1]){}
                        }else {
                            while (nums[++first] == nums[first-1]){}
                        }
                    }
                }
            }

        }
        return resultList;
    }

    private void sortNums(int[] nums) {
        int j;
        for (int gap = nums.length >> 1 ; gap > 0; gap /= 2){
            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                for (j = i; j >= gap && temp < nums[j-gap]; j -= gap) {
                    nums[j] = nums[j-gap];
                }
                nums[j] = temp;
            }
        }
    }


    public List<List<Integer>> bestSolution(int[] nums) {
        int len = nums.length;
        if (len < 3)
            return new ArrayList<List<Integer>>();

        Arrays.sort(nums);  //sort the array first
        List<List<Integer>> res = new ArrayList<>();
        int max = Math.max(nums[len - 1], Math.abs(nums[0])); //to allocate enough space to avoid check in if statement

        byte[] hash = new byte[(max<<1) + 1];
        for (int v : nums) { //hash and count appearing times of every num
            hash[v + max]++;
        }

        int lastNeg = Arrays.binarySearch(nums, 0); //search the position of 0; it also means the position of the last negative number in array
        int firstPos = lastNeg; //the position of the first positive number in array
        if(lastNeg < 0){    //0 not found
            firstPos = ~lastNeg;
            lastNeg = -lastNeg - 2;//see the Java api
        }
        else{               //found
            while(lastNeg >=0 && nums[lastNeg] == 0) //skip all 0
                --lastNeg;
            while(firstPos < len && nums[firstPos] == 0)
                ++firstPos;
            int zeroCount = firstPos - lastNeg - 1;
            if (zeroCount >= 3) { // (0 appears 3 times at least)
                res.add(Arrays.asList(0, 0, 0));
            }
            if (zeroCount > 0 ) { // (0 appears 1 times at least)
                for (int i = firstPos; i < len; ++i) { //traverse all the positive numbers to see whether there is a negative number whose absolute value equals to the positive number
                    if(i > firstPos && nums[i] == nums[i - 1]) //skip the same elements
                        continue;
                    if ( hash[-nums[i] + max] > 0) {
                        res.add(Arrays.asList(0, nums[i], -nums[i]));
                    }
                }
            }
        }

        // one positive number and two negetive numbers
        for (int i = firstPos; i < len; ++i) { //traverse all the positive numbers to find whether there are two negative numbers to make the 3 numbers added up to 0
            if(i > firstPos && nums[i] == nums[i - 1]) //skip the same elements
                continue;
            int half;   //we can traverse only half of the positive numbers
            if(nums[i] % 2 != 0)
                half = -((nums[i]>>1) + 1);
            else{
                half = -(nums[i]>>1);
                if(hash[half + max] > 1)
                    res.add(Arrays.asList(nums[i], half, half));
            }
            for(int j = lastNeg; j >=0 && nums[j] > half; --j){
                if(j < lastNeg && nums[j] == nums[j + 1])
                    continue;
                if(hash[(-nums[i] - nums[j]) + max] > 0)
                    res.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
            }
        }

        // one negative number and two positive numbers
        for (int i = lastNeg; i >= 0; --i) { //traverse all the negative numbers to find whether there are two positive numbers to make the 3 numbers added up to 0
            if(i < lastNeg && nums[i] == nums[i + 1])//skip the same elements
                continue;
            int half; //we can traverse only half of the negative numbers
            if(nums[i] % 2 != 0)
                half = -(nums[i] / 2 - 1);
            else{
                half = -(nums[i]>>1);
                if(hash[half + max] > 1)
                    res.add(Arrays.asList(nums[i], half, half));
            }
            for(int j = firstPos; j < len && nums[j] < half; ++j){
                if(j > firstPos && nums[j] == nums[j - 1])
                    continue;
                if(hash[(-nums[i] - nums[j]) + max] > 0)
                    res.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        ResultOfAddingTreeNum treeNum = new ResultOfAddingTreeNum();
        System.out.println("the result is "+treeNum.threeSum(nums));
        System.out.println("after sotred nums is");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" , ");
        }
    }
}
