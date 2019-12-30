package algorithm.EasyQuestion;

/**
 * @author kaithy.xu
 * @date 2019-10-01 21:27
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length < 1) {
            return "";
        }
        return search(strs,0,strs.length-1);
    }

    /**
     * 利用for循环进行搜索
     * @param strs
     * @return
     */
    private String resolveMethod1(String[] strs) {
        if(strs.length < 1) {
            return "";
        }
        String compare = strs[0];

        for (int i = 1; i < strs.length; i++) {
            char[] compareChars = compare.toCharArray();
            char[] ichars = strs[i].toCharArray();
            int j = 0;
            while (j < Math.min(compareChars.length,ichars.length) && compareChars[j] == ichars[j]){
                ++j;
            }
            compare = compare.substring(0,j);
        }

        return compare;
    }

    /**
     * 利用递归进行横向搜索
     * @param strs
     * @param left
     * @param right
     * @return
     */
    private String search(String[] strs,int left, int right) {
        if(left >= right) {
            return strs[left];
        }

        int middle = left + right >> 1;

        String leftResult = search(strs, left, middle);
        String rightResult = search(strs, middle+1, right);
        int i = 0;
        char[] leftChars = leftResult.toCharArray();
        char[] rightChars = rightResult.toCharArray();
        while (i < Math.min(leftChars.length,rightChars.length) && leftChars[i] == rightChars[i]){
            ++i;
        }

        return leftResult.substring(0,i);
    }

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println("the result is "+new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
