package leeteCode;

/**
 * 给定一个字符串，求出最长无重复纸船的长度
 * @author kaithy.xu
 * @date 2019/5/23 20:07
 */
public class NoRepeatSubString {

    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.equals("")){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        char[] charArray = s.toCharArray();
        int first =0;
        int last = 1;
        int maxLength = 0;

        for (;last<s.length();last++){

            if(!s.substring(first,last).contains(String.valueOf(charArray[last]))){

                maxLength = Math.max(maxLength,(last-first+1));

            }else {

                first = first+s.substring(first,last).indexOf(String.valueOf(charArray[last]))+1;
                maxLength = Math.max(maxLength,(last-first+1));
            }
        }

        return maxLength;
    }

    public int Solution2(String s) {

        if(s == null || s.equals("")){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        char[] charArray = s.toCharArray();
        int first =0;
        int last = 1;
        int maxLength = 0;

        for (;last<s.length();last++){

            String sub = s.substring(first,last);
            char[] tempCharArray = sub.toCharArray();

            for (int i=0;i<sub.length();i++){

                if(tempCharArray[i] == charArray[last]){
                    first = first+i+1;
                    break;
                }
            }

            maxLength = Math.max(maxLength,(last-first+1));

        }

        return maxLength;
    }

    public static void main(String[] args){
        NoRepeatSubString sub = new NoRepeatSubString();

//        int result = sub.lengthOfLongestSubstring(" ");

        int result2 = sub.Solution2("pwwkew");

        System.out.println("result is :"+result2);
    }
}
