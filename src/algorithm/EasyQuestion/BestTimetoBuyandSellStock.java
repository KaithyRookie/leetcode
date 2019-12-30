package algorithm.EasyQuestion;

/**
 * 买卖股票的最佳时机
 * @author kaithy.xu
 * @date 2019-09-10 12:21
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {

        if (prices.length < 1) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        System.out.println("the result is "+ new BestTimetoBuyandSellStock().maxProfit(prices));
    }
}
