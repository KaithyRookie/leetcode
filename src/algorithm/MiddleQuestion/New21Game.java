package algorithm.MiddleQuestion;

/**
 * 题目：
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 *
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
 *
 * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
 *
 *
 * 题解：假设dp[x] 是 点数为 x时的获胜概率，也就是小于等于N的概率
 * 由题目可知，点数最大为 X-1+W，在 K ～ Math(N,X-1+W) 区间内，只要小于，dp[x] = 1
 * 那么可以推断出概率转移方程 dp[x] = 1/W * (dp[x+1]+dp[x+2]+...+dp[x+W]) ,因为从1～W中选一个数的概率是等可能的
 *
 * 进一步推导：
 * dp[x] - dp[x+1] = 1/W * (dp[x+1] - dp[x+W+1]) 此时 x 属于 [0,K-1)这个区间
 *
 * dp[x] = dp[x+1] - 1/W * (dp[x+1] - dp[x+W+1])
 *
 * 因为x+1 == K 时无法再进行抽牌
 *
 * dp[K-1] = 1/W * (dp[K+1]+dp[K+2]+...+dp[K+W]), 因为 在区间[K,Math.min(N,K-1+W)] 这个区间内的概率为1，超过这个区间的概率为0，所以
 * dp[K-1] = 1/W * (Math.min(N,K-1+W) - (K-1)) = 1/W * (Math.min(N-K+1, W)
 * @author kaithy.xu
 * @date 2020-06-03 20:47
 */
public class New21Game {

    public double new21Game(int N, int K, int W) {

        if(K == 0) {
            return 1.0;
        }

        double[] dp = new double[K+W];
        for (int i = K; i <= N && i < K+W; i++) {
            dp[i] = 1;
        }
        dp[K-1] = 1.0 * Math.min(N-K+1, W)/W;
        for (int i = K-2; i >= 0; i--) {

            dp[i] = dp[i+1] - (dp[i+W+1] - dp[i+1]) /W;
        }

        return dp[0];
    }


    public static void main(String[] args) {
        int N = 21;
        int K = 17;
        int W = 10;
        New21Game game = new New21Game();
        System.out.println("the result is "+game.new21Game(N, K, W));
    }
}
