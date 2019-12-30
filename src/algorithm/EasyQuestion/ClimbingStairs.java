package algorithm.EasyQuestion;

/**
 * 爬楼梯
 * @author kaithy.xu
 * @date 2019-10-01 22:28
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if(1 == n) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("the result is "+new ClimbingStairs().climbStairs(4));
    }

}
