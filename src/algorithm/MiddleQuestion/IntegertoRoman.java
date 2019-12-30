package algorithm.MiddleQuestion;

/**
 * 整数转罗马数字
 * @author kaithy.xu
 * @date 2019-09-26 12:05
 */
public class IntegertoRoman {

    private static final int I = 1;
    private static final int IV = 4;
    private static final int V = 5;
    private static final int IX= 9;
    private static final int X = 10;
    private static final int XL = 40;
    private static final int L = 50;
    private static final int XC = 90;
    private static final int C = 100;
    private static final int CD = 400;
    private static final int D = 500;
    private static final int CM = 900;
    private static final int M = 1000;

    public String intToRoman(int num) {
        StringBuffer buffer = new StringBuffer();
        while (num >= M) {
            buffer.append("M");
            num -= M;
        }
        while (num >= CM) {
            buffer.append("CM");
            num -= CM;
        }
        while (num >= D) {
            buffer.append("D");
            num -= D;
        }
        while (num >= CD) {
            buffer.append("CD");
            num -= CD;
        }
        while (num >= C) {
            buffer.append("C");
            num -= C;
        }
        while (num >= XC) {
            buffer.append("XC");
            num -= XC;
        }
        while (num >= L) {
            buffer.append("L");
            num -= L;
        }
        while (num >= XL) {
            buffer.append("XL");
            num -= XL;
        }
        while (num >= X) {
            buffer.append("X");
            num -= X;
        }
        while (num >= IX) {
            buffer.append("IX");
            num -= IX;
        }
        while (num >= V) {
            buffer.append("V");
            num -= V;
        }

        while (num >= IV) {
            buffer.append("IV");
            num -= IV;
        }
        while (num > 0) {
            buffer.append("I");
            num -= I;
        }

        return buffer.toString();

    }

    public String intToRoman2(int num) {
        StringBuffer buffer = new StringBuffer();
        while (num >= 1000) {
            buffer.append("M");
            num -= 1000;
        }
        while (num >= 900) {
            buffer.append("CM");
            num -= 900;
        }
        while (num >= 500) {
            buffer.append("D");
            num -= 500;
        }
        while (num >= 400) {
            buffer.append("CD");
            num -= 400;
        }
        while (num >= 100) {
            buffer.append("C");
            num -= 100;
        }
        while (num >= 90) {
            buffer.append("XC");
            num -= 90;
        }
        while (num >= 50) {
            buffer.append("L");
            num -= 50;
        }
        while (num >= 40) {
            buffer.append("XL");
            num -= 40;
        }
        while (num >= 10) {
            buffer.append("X");
            num -= 10;
        }
        while (num >= 9) {
            buffer.append("IX");
            num -= 9;
        }
        while (num >= 5) {
            buffer.append("V");
            num -= 5;
        }

        while (num >= 4) {
            buffer.append("IV");
            num -= 4;
        }
        while (num > 0) {
            buffer.append("I");
            num -= 1;
        }

        return buffer.toString();
    }


    public static void main(String[] args) {
        System.out.println("the result is "+new IntegertoRoman().intToRoman(1));
    }
}
