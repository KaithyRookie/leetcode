package algorithm.EasyQuestion;

import java.util.regex.Pattern;

/**
 * 字符串转换整数 (atoi)
 * @author kaithy.xu
 * @date 2019-09-24 12:02
 */
public class String2Integer {

    public int myAtoi(String str) {

        if(null == str || "".equals(str)) {
            return 0;
        }
        long resule = 0;
        int label = 1;
        int i = 0;
        char temp = ' ';
        for (; i < str.length(); i++) {
            temp = str.charAt(i);
            if(' ' != temp) {
                break;
            }
        }
        if('-' == temp) {
            label = -1;
            i++;
        }else if('+' == temp) {
            label = 1;
            i++;
        }

        for (; i < str.length(); i++) {
            temp = str.charAt(i);
            if(Character.isDigit(temp)) {
                resule = resule*10+(int) temp - '0';
                if(resule > Integer.MAX_VALUE) {
                    return label == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }else {
                break;
            }
        }

        return (int) resule*label;

    }

    public static void main(String[] args) {
        System.out.println("the result is "+new String2Integer().myAtoi("   -42"));
    }
}
