package algorithm.MiddleQuestion;

/**
 * 字符串相乘
 * @author kaithy.xu
 * @date 2019-09-26 18:11
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2))
            return "0";

        int[] record = new int[num1.length()+num2.length()];

        for (int i = num2.length()-1; i >= 0 ; i--) {
            for (int j = num1.length()-1; j >= 0 ; j--) {

                int re = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                record[i+j+1] += re % 10;
                record[i+j] += re / 10;

                if(record[i+j+1] >= 10) {
                    record[i+j] += 1;
                    record[i+j+1] %= 10;
                }
                if(record[i+j] >= 10) {
                    record[i+j-1] +=1;
                    record[i+j] %= 10;

                }

            }
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < record.length; i++) {
            if(record[i] == 0 && buffer.length() < 1) {
                continue;
            }
            buffer.append(record[i]);
        }
        if(buffer.length() == 0) {
            return "0";
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println("the result is "+new MultiplyStrings().multiply("123","456"));
    }
}
