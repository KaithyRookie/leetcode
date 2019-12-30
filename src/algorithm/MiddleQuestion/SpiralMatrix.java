package algorithm.MiddleQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * @author kaithy.xu
 * @date 2019-09-04 19:02
 */
public class SpiralMatrix {

    int[] a = new int[6];
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if(matrix.length < 1) {
            return result;
        }
        int i=0,j=0;
        int col = matrix[0].length-1;
        int row = matrix.length-1;
        while (col >= i && row >= j) {
            if(j == col && i == row) {
                result.add(matrix[i][j]);
            }else if(j != col && i != row) {
                addColElement(matrix,j,col-1,i,result);

                addRowElement(matrix,i,row-1,col,result);

                addColElement(matrix,col,j+1,row,result);

                addRowElement(matrix,row,i+1,j,result);
            }else {
                if(i != row) {
                    addRowElement(matrix,i,row,j,result);
                }else {
                    addColElement(matrix,j,col,i,result);
                }
            }
            ++i;
            ++j;
            --col;
            --row;
        }
        return result;
    }

    /**
     * 固定行以遍历列
     * @param matrix
     * @param left
     * @param right
     * @param row
     * @param result
     */
    private void addColElement(int[][] matrix, int left ,int right, int row,List<Integer> result) {
        if(left < right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[row][i]);
            }
        }else if(left > right){
            for (int i = left; i >= right ; i--) {
                result.add(matrix[row][i]);
            }
        }else {
            result.add(matrix[row][left]);
        }

    }

    /**
     * 固定列以遍历行
     * @param matrix
     * @param head
     * @param tail
     * @param col
     * @param result
     */
    private void addRowElement(int[][] matrix, int head, int tail, int col, List<Integer> result) {
        if(head < tail) {
            for (int i = head; i <= tail; i++) {
                result.add(matrix[i][col]);
            }
        }else if(head > tail){
            for (int i = head; i >= tail ; i--) {
                result.add(matrix[i][col]);
            }
        }else {
            result.add(matrix[head][col]);
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3,4},{ 5, 6,7,8},{9,10,11,12}};
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{1,2},{3,4}};
        List<Integer> result = new SpiralMatrix().spiralOrder(matrix);
        System.out.println("the result is ");
        for(Integer ele : result){
            System.out.print(ele+",");
        }
    }

}
