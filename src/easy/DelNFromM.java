package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数，给出一个算法去掉n位后得到剩余位数的最大值，删除的数的位置由下一位代替
 * 如m=51342,n=1,删除1后最大值为5342
 * @author kaithy.xu
 * @date 2019-12-24 21:16
 */
public class DelNFromM {

    public int solution(int m, int n) {

        List<Integer> numbers = new ArrayList<>();
        while (m != 0) {
            numbers.add(m%10);
            m = m/10;
        }
        int result = 0;
        for (int i = numbers.size()-1; i > 0; i--) {
            if(n > 0) {
                if(numbers.get(i) >= numbers.get(i-1)) {
                    result = result*10 + numbers.get(i);
                }else {
                    n--;
                }
            }else {
                result = result*10 + numbers.get(i);

            }
        }
        if(n == 0) {
            result = result*10 + numbers.get(0);
        }

        return result;
    }

    public static void main(String[] args) {
        DelNFromM delNFromM = new DelNFromM();
        int m = 35467;
        int n=2;
        int result = delNFromM.solution(m, n);

        System.out.println("the result is "+result);
    }
}
