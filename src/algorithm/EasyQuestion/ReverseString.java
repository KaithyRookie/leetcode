package algorithm.EasyQuestion;

/**
 * 反转字符串
 * @author kaithy.xu
 * @date 2019-09-27 12:17
 */
public class ReverseString {

    public void reverseString(char[] s) {

        int head = 0,tail = s.length-1;
        while (tail > head) {
            int diff = s[tail] - s[head];

            s[head++] += diff;
            s[tail--] -=diff;
        }

    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        new ReverseString().reverseString(s);
        System.out.println("the result is "+s);
    }
}
