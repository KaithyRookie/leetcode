package leeteCode;

/**
 * @author kaithy.xu
 * @date 2019/5/27 20:38
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if(s.length() < 2){
            return s;
        }
        int first=0,temp=0;
        int last = s.length()-1;
        int right=0,left=0;

        while (first<s.length()-1){

            if(temp == last && right ==0){
                first++;
                last = s.length()-1;
                temp=first;
                continue;
            }
            if(s.charAt(temp) == s.charAt(last)){
                if(temp >= last){
                    left = Math.max(left,first);
                    break;
                }
                right = Math.max(right,last);
                temp ++;
                last--;
            }else {

                if(temp != first){
                    first++;
                    last = s.length()-1;
                }else {
                    last--;
                }
                temp = first;
                right = 0;

            }

        }

        if(right < first){
            first = 0;
        }
        return s.substring(first,right+1);
    }

    public static void main(String[] args){
        LongestPalindromicSubstring sub = new LongestPalindromicSubstring();

        String result = sub.longestPalindrome("babadada");

        System.out.println("the result is :"+result);
    }
}
