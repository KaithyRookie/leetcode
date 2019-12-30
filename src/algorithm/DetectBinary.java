package algorithm;

/**
 * @author kaithy.xu
 * @date 2019/8/12 12:17
 */
public class DetectBinary {
    public boolean isPowerOfTwo(int n) {

        for(int i=0;i<32;i++){
            int temp = n >> i;
            int large =  temp << i;
            if(n != large){
                return false;
            }
            if(temp == 1){
                return true;
            }
        }
        return false;
    }

    public boolean isPowerOfTwo2(int n){

        return (n > 0) && ((n & (-n)) == n);
    }

    public static void main(String[] args){
        DetectBinary detectBinary = new DetectBinary();

        System.out.println("is Binary :"+detectBinary.isPowerOfTwo2(16));
    }
}
