package algorithm.MiddleQuestion;

/**
 * 解题思路：
 * 外层遍历所有节点
 * 内层利用DFS以及备忘录进行节点搜索
 *
 * 在遍历是，需要重点关注备忘录状态的回退，当递归到某一节点不满足时，开始回溯时，备忘录也要重置回未使用状态
 * 递归时，对于每一个节点，都有四个方向，四个方向都要进行一次深度搜索，如果四个方向搜索都不成功时，当前节点的备忘录要回滚会原来的位置
 *
 *
 * @author kaithy.xu
 * @date 2020-06-22 20:13
 */
public class FindWords {

    public boolean exist(char[][] board, String word) {

        char[] chars = word.toCharArray();

        int width = board.length;
        int height = board[0].length;


        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                if(board[i][j] == chars[0]) {
                    if(checkExists(board,chars,i,j,0, new boolean[width][height])) {
                       return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkExists(char[][] board, char[] chars, int x, int y, int index, boolean[][] memo) {

        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || memo[x][y]) {
            return false;
        }

        if(index == chars.length-1) {
            return board[x][y] == chars[index];
        }

        boolean isExists = false;
        if(board[x][y] == chars[index]) {
            System.out.println("["+x+","+y+"]"+board[x][y]);
            memo[x][y] = true;
            isExists = checkExists(board, chars, x+1, y, index+1, memo);
            if(isExists) {
                return true;
            }
            isExists = checkExists(board, chars, x-1, y, index+1, memo);

            if(isExists){
                return true;
            }
            isExists = checkExists(board, chars, x, y+1, index+1, memo);
            if(isExists){
                return true;
            }

            isExists = checkExists(board, chars, x, y-1, index+1, memo);

            if(isExists){
                return true;
            }
            memo[x][y] = false;

        }
        return isExists;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

//        char[][] board = {{'A'}};
        String word = "ABCB";

        System.out.println(new FindWords().exist(board, word));
    }
}
