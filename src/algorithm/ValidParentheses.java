package algorithm;

/**
 * 领扣腾讯50题--有效的括号
 * @author kaithy.xu
 * @date 2019/8/4 12:11
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        if(s.length() ==0){
            return true;
        }
        char[] tempArray = new char[s.length()];

        char[] schars = s.toCharArray();
        int left=0;

        for (int i = 0; i <s.length() ; i++) {

            if(left == 0){
                tempArray[left++] = s.charAt(i);
            }else {
                if(String.valueOf(tempArray[left-1]).equals("(")){

                    if(s.substring(i,i+1).equals(")")){
                        left--;
                    }else {
                        tempArray[left++] = s.charAt(i);
                    }

                }else if(String.valueOf(tempArray[left-1]).equals("{")){

                    if(s.substring(i,i+1).equals("}")){
                        left--;
                    }else {
                        tempArray[left++] = s.charAt(i);
                    }

                }else if(String.valueOf(tempArray[left-1]).equals("[")){

                    if(s.substring(i,i+1).equals("]")){
                        left--;
                    }else {
                        tempArray[left++] = s.charAt(i);
                    }

                }
            }


        }
        return left==0;
    }

    private static boolean temp(String s){

        if(s.length() ==0){
            return true;
        }

        int left = 0;

        char[] schars = s.toCharArray();
        char[] temp = new char[s.length()];

        for (int i = 0; i <s.length() ; i++) {
            if(schars[i] == '(' || schars[i] == '{' || schars[i] == '['){
                temp[left++] = schars[i];
            }else {
                if(left < 1){
                    return false;
                }
                if(temp[left-1] == '('){

                    if(schars[i] == ')'){
                        left--;
                    }else {
                        return false;
                    }
                }else if(temp[left-1] == '{'){

                    if(schars[i] == '}'){
                        left--;
                    }else {
                        return false;
                    }

                }else if(temp[left-1] == '['){

                    if(schars[i] == ']'){
                        left--;
                    }else {
                        return false;
                    }

                }

            }

        }

        return left == 0;
    }

    public static void main(String[] args){
        String s = "{([}";
        System.out.println(ValidParentheses.temp(s));
    }
}
