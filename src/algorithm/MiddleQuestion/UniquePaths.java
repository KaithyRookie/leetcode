package algorithm.MiddleQuestion;

/**
 * 不同路径
 * @author kaithy.xu
 * @date 2019-09-08 19:46
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < n; i++) {
            matrix[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i-1][j]+matrix[i][j-1];
            }
        }

        return matrix[m-1][n-1];
    }

    public int solution(int m, int n) {
        int[][] matrix = new int[m][n];
        return search(m-1,n-1,matrix);
    }

    private int search(int i, int j,int[][] matrix ) {
        if(i==0 || j == 0) {
            return 1;
        }
        if(matrix[i][j] != 0){
            return matrix[i][j];
        }
        int headUp = search(i,j-1,matrix);
        int headLeft = search(i-1,j,matrix);
        matrix[i][j] = headLeft+headUp;
        return headUp+headLeft;

    }

    public static void main(String[] args) {
        System.out.println("the result is "+new UniquePaths().solution(7,3));
    }
}
