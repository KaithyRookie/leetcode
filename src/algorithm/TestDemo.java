package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kaithy.xu
 * @date 2019/8/10 14:51
 */
public class TestDemo {

    public int value1;

    public int value2;

    public String value3;

    public TestDemo(){

    }

    public TestDemo(int v1,int v2,String v3){
        this.value1 = v1;
        this.value2 = v2;
        this.value3 = v3;
    }

    @Override
    public String toString() {
        return String.format("value1 : %d ,value2: %d,value3: %s",value1,value2,value3);
    }

    public static void main(String[] args){
        List<TestDemo> list = new ArrayList<>();
        TestDemo demo1 = new TestDemo(1,2,"test");

        TestDemo demo2 = new TestDemo(3,4,"test1");

        list.add(demo1);
        list.add(demo2);

        System.out.println("list value :");
        for (TestDemo demo : list){
            System.out.println(demo.toString());
        }

        List<TestDemo> copyList = new ArrayList<>(list);

        System.out.println("copy list value :");
        for (TestDemo demo : copyList){
            System.out.println(demo.toString());
        }


        System.out.println("---------value change-----");

        list.get(0).value1 = 11;

        copyList.get(1).value2 = 12;

        copyList.add(new TestDemo(3,4,"add"));

        System.out.println("list value :");
        for (TestDemo demo : list){
            System.out.println(demo.toString());
        }

        System.out.println("copy list value :");
        for (TestDemo demo : copyList){
            System.out.println(demo.toString());
        }


        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);

        for (Integer i : list1){
            System.out.println(i);
        }
        List<Integer> copyList1 = new ArrayList<>(list1);

        System.out.println("copy list:");
        for (Integer i : copyList1){
            System.out.println(i);
        }

        list1.set(0,3);

        copyList1.set(1,4);
        System.out.println("after change");

        copyList1.add(5);
        for (Integer i : list1){
            System.out.println(i);
        }

        System.out.println("copy list:");
        for (Integer i : copyList1){
            System.out.println(i);
        }

    }
}
