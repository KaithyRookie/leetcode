package algorithm.EasyQuestion;

/**
 * 整数反转
 * @author kaithy.xu
 * @date 2019-09-23 12:18
 */
public class ReverseInteger {

    public int reverse(int x) {

        long result = 0L;
        int returnValue = 0;
        for (;x != 0;result=result*10+x%10,returnValue=returnValue*10+x%10,x /= 10);
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return returnValue;
    }

    public static void main(String[] args) {
        System.out.println("the result is "+new ReverseInteger().reverse(123));
    }
}
