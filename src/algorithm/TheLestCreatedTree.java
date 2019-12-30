package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kaithy.xu
 * @date 2019/7/1 15:54
 */
public class TheLestCreatedTree {

    public static int[] createTree(int[][] matrix){

        //最小生成树数组，下标是图的点编号，下标对应内容是其父节点
        int[] createdArray = new int[matrix.length];

        List<Integer> reachedArrayList = new ArrayList<>();

        reachedArrayList.add(0);

        createdArray[0] = -1;

        int weight;
        int fromIndex = 0;
        int toIndex = 0;
        while (reachedArrayList.size() < matrix.length){

            weight = -1;

            for (Integer reachedIndex : reachedArrayList){
                for (int i=0; i<matrix.length ; i++){

                    if(!reachedArrayList.contains(i)){

                        if(matrix[reachedIndex][i] != -1){

                            if(weight == -1 || matrix[reachedIndex][i] < weight){
                                fromIndex = reachedIndex;
                                toIndex = i;
                                weight = matrix[reachedIndex][i];

                            }
                        }
                    }
                }
            }

            //已遍历路径记录
            reachedArrayList.add(toIndex);
            //加入最小生成树数组
            createdArray[toIndex] = fromIndex;
        }

        return createdArray;
    }

    public static void main(String[] args){

        int[][] matrix = new int[][]{
            {0,4,3,-1,-1},
            {4,0,8,7,-1},
            {3,8,0,-1,1},
            {-1,7,-1,0,9},
            {-1,-1,1,9,0},
        };

        int[] parents = createTree(matrix);

        System.out.println(Arrays.toString(parents));
    }
}
