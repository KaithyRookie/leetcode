package algorithm;

/**
 * @author kaithy.xu
 * @date 2019/8/7 12:05
 */
public class BestOcassionSoldStock {
    public int maxProfit(int[] prices) {

        if(prices.length <=1){
            return 0;
        }
        int[] trees = new int[prices.length];
        digest(prices,trees);

        union(trees,prices);
        int profit = 0;
        for (int i = trees.length-1; i >= 0; i--) {

            int root = find(i,trees);
            if(root != i){
                profit = Math.max(prices[i]-prices[root],profit);
            }

        }
        return profit;

    }

    private int[] digest(int[] prices,int[] trees){

        for (int i = 0; i < prices.length; i++) {
            trees[i] = -1;
        }
        return trees;
    }

    private void union(int[] trees,int[] prices){

        for (int i = 1; i < trees.length; i++) {

            if(prices[i] > prices[find(i-1,trees)]){
                trees[i] = i-1;
            }

        }

    }

    private int find(int x,int[] trees){

        if(trees[x] < 0){
            return x;
        }else {
            return find(trees[x],trees);
        }
    }

    public int maxProfit2(int[] prices){
        if(prices.length <=1){
            return 0;
        }
        int i=0;
        int right = prices[0];
        int left = prices[0];
        int sum = 0;
        while (i<prices.length-1){
            while (i < prices.length-1 && prices[i+1] <= prices[i]){
                i++;
            }
            left = prices[i];

            while (i < prices.length-1 && prices[i+1] >= prices[i]){
                i++;
            }
            right = prices[i];
            sum+= right - left;
        }

        return sum;
    }

    public int maxProfit3(int[] prices){
        if(prices.length <=1){
            return 0;
        }
        int index = 0;
        int sum = 0;
        while (index < prices.length-1){
            while (index < prices.length-1 && prices[index+1] <= prices[index]){
                index++;
            }

            int i = index;
            while (i < prices.length){
                sum = Math.max(sum,prices[i++]-prices[index]);
            }
            index++;

        }

        return sum;
    }


    public static void main(String[] args){
        BestOcassionSoldStock stock = new BestOcassionSoldStock();

        int[] prices = new int[]{7,1,5,3,6,4};
//        System.out.println("max profit: "+stock.maxProfit3(prices));

        System.out.println("max profit2: "+stock.maxProfit(prices));
//        int[] prices = new int[30000];
//        for (int i = 0; i < 300; i++) {
//            prices[i] = (int)(Math.random()*10);
//        }
//        long start1 = System.currentTimeMillis();
//        int profit = stock.maxProfit(prices);
//        long end1 = System.currentTimeMillis();
//        System.out.println("cost :"+(end1-start1)+" max profit :"+profit);
//
//        long start2 = System.currentTimeMillis();
//        int profit2 = stock.maxProfit2(prices);
//        long end2 = System.currentTimeMillis();

//        System.out.println("cost :"+(end2-start2)+" max profit :"+profit2);
//        stock.union(trees,prices);
//        for (int i = 0; i < trees.length; i++) {
//            int temp = trees[i] ;
//            if(temp < 0){
//                System.out.println("");
//                System.out.println(prices[i]);
//            }else {
//                System.out.print(prices[temp]+"<--"+prices[i]+"<--");
//            }
//        }
    }
}
