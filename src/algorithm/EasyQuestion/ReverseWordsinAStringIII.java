package algorithm.EasyQuestion;

/**
 * 反转字符串中的单词 III
 * @author kaithy.xu
 * @date 2019-09-27 12:29
 */
public class ReverseWordsinAStringIII {

    public String reverseWords(String s) {

        char[] chars = s.toCharArray();
        int head = 0;
        for (int i = 0; i <= chars.length; i++) {

            if(i == chars.length || ' ' == chars[i] ) {
                reverseCharArray(chars,head, i-1);
                head = i+1;
            }

        }
        return String.valueOf(chars);
    }

    private void reverseCharArray(char[] chars, int head, int tail) {
        while (head < tail) {
            int diff = chars[tail] - chars[head];
            chars[head++] += diff;
            chars[tail--] -= diff;
        }
    }

    public static void main(String[] args) {
        System.out.println("the result is "+new ReverseWordsinAStringIII().reverseWords("Let's take LeetCode contest"));
    }
}
