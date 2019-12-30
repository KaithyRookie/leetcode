package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 删除为无效括号
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * @author kaithy.xu
 * @date 2019-12-11 20:34
 */
public class RemoveInvalidParentheses {

    private Set<String> result = new HashSet<>();
    private int minDelNum;
    public List<String> solution(String s) {

        minDelNum = Integer.MAX_VALUE;
        char[] chars = s.toCharArray();

        search(chars,0,0,0,new StringBuilder(),0);
        return new ArrayList<>(result);
    }

    private void search( char[] chars, int i, int leftCount, int rightCount, StringBuilder buffer, int removeCount) {
        if(i == chars.length) {
            if(leftCount == rightCount) {
                if(removeCount <= minDelNum) {
                    if(removeCount < minDelNum) {
                        result.clear();
                        minDelNum = removeCount;
                    }
                    result.add(buffer.toString());
                }
            }
            return;
        }

        int length = buffer.length();
        if(chars[i] == '(' || chars[i] == ')') {
            search(chars,i+1,leftCount, rightCount,buffer,removeCount+1);
            buffer.append(chars[i]);
            if(chars[i] == '(') {
                search(chars,i+1,leftCount+1, rightCount,buffer,removeCount);
            }else if(rightCount < leftCount){
                search(chars,i+1,leftCount, rightCount+1,buffer,removeCount);
            }
            buffer.deleteCharAt(length);
        }else {
            search(chars,i+1,leftCount,rightCount,buffer.append(chars[i]),removeCount);
            buffer.deleteCharAt(length);
        }
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses parentheses = new RemoveInvalidParentheses();
        String s = "()())()";
        List<String> results = parentheses.solution(s);
        for (String result : results) {
            System.out.println(result);
        }
    }
}
