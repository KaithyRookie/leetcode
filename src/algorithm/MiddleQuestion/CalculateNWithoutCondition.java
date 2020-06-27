package algorithm.MiddleQuestion;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author kaithy.xu
 * @date 2020-06-02 16:50
 */
public class CalculateNWithoutCondition {

    public static int sumNums(int n) {

        boolean flag = n == 0 || (n += sumNums(n-1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(1));
    }
}
