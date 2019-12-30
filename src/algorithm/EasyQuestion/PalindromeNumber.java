package algorithm.EasyQuestion;

/**
 * 回文数
 * @author kaithy.xu
 * @date 2019-09-25 21:38
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        if(x < 0) {
            return false;
        }

        //若是回文一定在范围内
        int result = 0;
        int num = x;
        while (num != 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        return result == x;
    }
}
