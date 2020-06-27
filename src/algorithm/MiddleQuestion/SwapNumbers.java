package algorithm.MiddleQuestion;

/**
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值
 * 题解：
 * a1 = a-b
 * b1 = b+a1 = b + a -b =a
 * a2 = b1-a1 = b+a1-a1 = b
 * @author kaithy.xu
 * @date 2020-06-26 18:45
 */
public class SwapNumbers {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] - numbers[1];
        numbers[1] += numbers[0];
        numbers[0] = numbers[1] - numbers[0];
        return numbers;
    }

    public static void main(String[] args) {
        int[] num = {1,2};
        int[] res = new SwapNumbers().swapNumbers(num);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
