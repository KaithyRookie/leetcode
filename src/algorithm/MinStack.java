package algorithm;

import java.util.Stack;

/**
 * @author kaithy.xu
 * @date 2019/8/3 18:58
 */
public class MinStack {

    private int[] array;

    private int last;

    private int min;

    private int record;

    private int min_remainder;

    public MinStack() {
        array = new int[16];
        last=0;
        min = 0;
        record=-1;
        min_remainder = -1;
    }

    public void push(int x) {
        if(last >= array.length){
            this.array = expand(this.array);
        }
        if(last==0){
            this.min = x;
            array[last++] = x;
        }else if(this.min > x){
            if(x - (Integer.MIN_VALUE+1) < this.min){
                array[last++] = createVirtual(x);
            }else {
                array[last++] = (x<<1) - this.min;
            }
            this.min = x;

        }else {
            array[last++] = x;
        }


    }

    public void pop() {
        if(last -1 <0){
            return;
        }

        if(record == last){
            int temp  = array[last-1] ^ this.min;
            this.min = temp;
//            this.min = (this.min/10 - array[last-1] + this.min/10)*10+min_remainder;
        }else {
            if(array[last-1] < this.min){
                int temp = this.min<<1 - array[last-1];
                this.min = temp;
            }
        }
        this.last = this.last - 1;

        this.last = this.last < 0 ? 0:this.last;
    }

    public int top() {

        if(last -1 <0){
            return 0;
        }
        int result = 0;
        if(record == last || array[last-1] < this.min){
            result = this.min;
        }else {
            result = this.array[last-1];
        }
        return result;
    }

    public int getMin() {
        return this.min;
    }

    private int[] expand(int[] array){

        int[] tempArray = new int[array.length*2];
        for (int i=0;i<array.length;i++){
            tempArray[i] = array[i];
        }

        return tempArray;
    }

    private int findMin(int array[],int last){

        if(last <=0){
            return 0;
        }
        int tempMin = array[last-1];
        for (int i=last-1;i>=0;i--){
            tempMin = Math.min(array[i],tempMin);
        }
        return tempMin;

    }

    private int createVirtual(int x){

        int temp = 0;
        if(x - (Integer.MIN_VALUE+1) < this.min){
            record = this.last;

            min_remainder = this.min%10;
            temp = x/10 - this.min/10 + x/10;

//            int temp2 = (x/10 - temp + x/10)*10+min_remainder;

            return x^this.min;
        }else {
            temp = x << 1 - this.min;
        }

        return temp;
    }

    public static void main(String[] args){
        MinStack min = new MinStack();
        min.push(2147483646);
        min.push(2147483646);
        min.push(2147483647);
        min.top();
        min.pop();
        System.out.println("min:"+min.getMin());
        min.pop();
        System.out.println("min:"+min.getMin());
        min.pop();
        min.push(2147483647);
        min.top();
        min.push(-2147483648);
        System.out.println("top"+min.top());
        System.out.println("min:"+min.getMin());
        min.pop();
        System.out.println("min:"+min.getMin());


    }

}
