package algorithm;

/**
 * @author kaithy.xu
 * @date 2019/7/22 23:19
 */
public class AlmostPalindrome {

    public static boolean result(String t){

        char[] temp = t.toCharArray();
        int[] record = new int[2];
        int index = 0;
        for (int i=0,j=t.length()-1;i<=j;i++,j--){

            if(temp[i] != temp[j]){
                if(index<2) {
                    record[index++] = j;
                }else {
                    return false;
                }
            }
        }
        if(index == 2){

            char temp1= temp[record[0]];
            temp[record[0]] = temp[record[1]];
            temp[record[1]] = temp1;

            if(temp[record[0]] == temp[t.length()-record[0]-1] && temp[record[1]] == temp[t.length()-record[1]-1]){
                return true;
            }
        }else if(index == 0){
            return true;
        }


        return false;
    }

    public static void main(String[] args){
        String t = "ab";

        System.out.println(AlmostPalindrome.result(t));
    }
}
