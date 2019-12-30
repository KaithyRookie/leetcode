package algorithm.MiddleQuestion;

/**
 * @author kaithy.xu
 * @date 2019-09-29 12:14
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        return manacherSearch(s);
    }

    /**
     * 暴力搜索
     * @param s
     * @return
     */
    private String violenceSearch(String s) {
        if(s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int left =0,right=1;
        boolean[][] visited = new boolean[s.length()][s.length()];
        for (int i = 0; i < chars.length; i++) {
            int j = i+1;
            int cleft =i, cright = i;
            while (j < chars.length && j > i) {
                if(chars[j] == chars[i]) {
                    int gleft = i, gright= j;
                    while (!visited[gleft][gright] && chars[gleft] == chars[gright]) {
                        if(gleft >= gright) {
                            cleft = i;
                            cright = j;
                            break;
                        }
                        visited[gleft++][gright--] = true;
                    }
                }
                ++j;
            }
            if(visited[cleft][cright]) {
                if(cright + 1 - cleft > (right - left)) {
                    left = cleft;
                    right = cright+1;
                }
            }
        }
        return s.substring(left,right);
    }

    /**
     * 动态规划，备忘录模式：从子字符串的长度为1开始判断，利用二维数组保留已访问的节点，
     * @param s
     * @return
     */
    private String search(String s) {
        if(s.length() <= 1) {
            return s;
        }
        boolean[][] visited = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();

        int arrayLen = s.length();
        int maxLength = 0;
        int maxLeft=0,maxRight=1;
        for (int length = 2; length <= arrayLen; length++) {
            for (int start = 0; start < arrayLen; start++) {
                int end = start+length-1;
                if(end >= arrayLen) {
                    break;
                }

                visited[start][end] = ((length == 2 || length == 3 || visited[start+1][end-1]) && chars[start] == chars[end]);

                if(visited[start][end] && length > maxLength) {
                    maxLeft = start;
                    maxRight = end+1;
                }
            }
        }
        return s.substring(maxLeft,maxRight);
    }

    private String manacherSearch(String s) {
        if(s.length() <= 1) {
            return s;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("#");
        int length = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            buffer.append(chars[i]);
            buffer.append("#");
        }
        char[] expandedChars = buffer.toString().toCharArray();

        int[] radius = new int[expandedChars.length];

        //当前回文字符串所难访问到的边界
        int maxRight = 0;
        //当前回文字符串的中间位置
        int pos = 0;

        //最大长度
        int maxLen = 0;
        int left=0,right=0;

        for (int i = 1; i < expandedChars.length; i++) {

            if( i < maxRight) {
                radius[i] = Math.min(radius[2*pos-i],maxRight - i);
            }else {
                radius[i] = 1;
            }
            //尝试以i为中心向外扩展找到最大边界
            while (i - radius[i] >= 0 && i+ radius[i] < expandedChars.length && expandedChars[i-radius[i]] == expandedChars[i+radius[i]]) {
                radius[i] += 1;
            }

            if(radius[i]+i-1 > maxRight) {
                maxRight = radius[i] + i -1;
                pos = i;
            }
            if(radius[i] > maxLen) {
                right = radius[i] + i -1;
                left = 2 * pos - right ;
                maxLen = radius[i];
            }
        }

        return s.substring(left/2,right/2);
    }
    // 0 1 2 3 4 5
    // # a # b # c
    // a b c

    public static void main(String[] args) {
        System.out.println("the result is: "+new LongestPalindromicSubstring().longestPalindrome("acbcaa"));
    }
}
