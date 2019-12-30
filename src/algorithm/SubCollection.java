package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kaithy.xu
 * @date 2019/8/8 18:23
 */
public class SubCollection {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> totalSubLists = new ArrayList<>();

        for (int i = nums.length-1; i >=0; i--) {
            if(totalSubLists.size()==0){
                List<Integer> self = new ArrayList<>();
                self.add(nums[i]);
                totalSubLists.add(self);
                totalSubLists.add(new ArrayList<>());
            }else {
                int size = totalSubLists.size();
                int se=0;
                while (true){
                    List<Integer> self = new ArrayList<>();
                    self.add(nums[i]);
                    self.addAll(totalSubLists.get(se++));
                    totalSubLists.add(self);

                    if(se >= size){
                        break;
                    }

                }
            }


        }
        
        return totalSubLists;
    }


    
    
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        SubCollection sub = new SubCollection();
        List<List<Integer>> totalSubLists = sub.subsets(nums);

        for (List<Integer> list : totalSubLists){
            for (Integer num : list){
                System.out.print(num+"-->");
            }
            System.out.println("");
        }
    }

}
