package algorithm.MiddleQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 *  格雷编码
 * @author kaithy.xu
 * @date 2019-09-30 12:04
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {

        List<Integer> result = new ArrayList<>();
        int num = 1 << n;
        for (int i = 0; i < num; i++) {
            result.add(i ^ (i / 2));
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println("the result is "+new GrayCode().grayCode(2));
    }
}

