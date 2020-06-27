package algorithm.MiddleQuestion;

/**
 * @author kaithy.xu
 * @date 2020-06-26 19:03
 */
public class NumTeams {

    public int numTeams(int[] rating) {
        if(rating.length < 3) {
            return 0;
        }
        int[][] memo = new int[rating.length][rating.length];
        for (int i = 0; i < rating.length; i++) {
            for (int j = i+1; j < rating.length; j++) {
                if(rating[j] > rating[i]) {
                    memo[j][i] = 1;
                }else if(rating[j] < rating[i]) {
                    memo[j][i] = -1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < rating.length; i++) {

            for (int j = i+1; j < rating.length; j++) {
                if(memo[j][i] == 1) {
                    for (int k = j+1; k < rating.length; k++) {
                        if(memo[k][j] == 1) {
                            sum++;
                        }
                    }
                }else if(memo[j][i] == -1) {
                    for (int k = j+1; k < rating.length; k++) {
                        if(memo[k][j] == -1) {
                            sum++;
                        }
                    }
                }
            }
        }

        return sum;
    }

    public int numTeams2(int[] rating) {
        if(rating.length < 3) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < rating.length; i++) {
            for (int j = i+1; j < rating.length; j++) {
                for (int k = j+1; k < rating.length; k++) {
                    if(rating[k]> rating[j] && rating[j] > rating[i]) {
                        ++sum;
                    }else if(rating[k] < rating[j] && rating[j] < rating[i]) {
                        ++sum;
                    }
                }
            }
        }
        return sum;
    }

    public int numTeams3(int[] rating) {
        int sum = 0;
        for (int i = 1; i < rating.length-1; i++) {
            int l_less=0,l_more=0;
            int r_less = 0, r_more = 0;
            for (int j = 0; j < i; j++) {
                if(rating[j] < rating[i]) {
                    ++l_less;
                }else if(rating[j] > rating[i]) {
                    ++l_more;
                }
            }

            for (int j = i+1; j < rating.length; j++) {
                if(rating[j] > rating[i]) {
                    ++r_more;
                }else if(rating[j] < rating[i]) {
                    ++r_less;
                }
            }

            sum += l_less * r_more + l_more * r_less;
        }

        return sum;
    }
    public static void main(String[] args) {
        int[] rating = {2,5,3,4,1};
        System.out.println(new NumTeams().numTeams3(rating));
    }


}
