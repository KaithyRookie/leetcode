package algorithm.MiddleQuestion;

import java.util.List;

/**
 * 螺旋矩阵II
 * @author kaithy.xu
 * @date 2019-09-06 12:10
 */
public class SpiralMatrixII {

    private int element = 1;

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i=0,j=0;
        int col = n-1;
        int row = n-1;
        while (col >= i && row >= j) {
            if(j == col && i == row) {
                matrix[i][j] = element++;
            }else if(j != col && i != row) {
                addColElement(matrix,j,col-1,i);

                addRowElement(matrix,i,row-1,col);

                addColElement(matrix,col,j+1,row);

                addRowElement(matrix,row,i+1,j);
            }
            ++i;
            ++j;
            --col;
            --row;
        }
        return matrix;
    }

    /**
     * 固定行以遍历列
     * @param matrix
     * @param left
     * @param right
     * @param row
     */
    private void addColElement(int[][] matrix, int left , int right, int row) {
        if(left < right) {
            for (int i = left; i <= right; i++) {
                matrix[row][i] = element++;
            }
        }else if(left > right){
            for (int i = left; i >= right ; i--) {
                matrix[row][i] = element++;
            }
        }else {
            matrix[row][left] = element++;
        }

    }

    /**
     * 固定列以遍历行
     * @param matrix
     * @param head
     * @param tail
     * @param col
     */
    private void addRowElement(int[][] matrix, int head, int tail, int col) {
        if(head < tail) {
            for (int i = head; i <= tail; i++) {
                matrix[i][col] = element++;
            }
        }else if(head > tail){
            for (int i = head; i >= tail ; i--) {
                matrix[i][col] = element++;
            }
        }else {
            matrix[head][col] = element++;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] matrix = new SpiralMatrixII().generateMatrix(n);
        System.out.println("[");
        for (int i = 0; i < n; i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+",");
            }
            System.out.println("]");

        }

        System.out.println("]");
    }
}
