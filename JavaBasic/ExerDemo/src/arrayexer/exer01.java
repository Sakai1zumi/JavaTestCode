package arrayexer;

import org.junit.Test;

/**
 * 面试题目：创建一个长度为6的int型数组，要求取值为1-30，同时元素值各不相同
 *
 * @author TuHong
 * @create 2021-02-22 14:48
 */
public class exer01 {

    @Test
    public void test1() {
        int[] arr = new int[6];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 30 + 1);

            boolean flag = false;
            while(true){
                for (int j = 0; j < i; j++) {
                    if(arr[j] == arr[i]){
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    arr[i] = (int) (Math.random() * 30 + 1);
                    flag = false;
                    continue;
                }
                break;
            }
        }

        for (int value : arr){
            System.out.print(value + "\t");
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[6];

        for (int i = 0; i < arr.length; i++) {
            arr[i] =(int) (Math.random() * 30 + 1);

            for (int j = 0; j < i; j++) {
                if(arr[j] == arr[i]){
                    i--;//重复生成arr[i]位置上的元素，直到与前面的所有值都不相等
                    break;
                }
            }
        }

        for (int v : arr){
            System.out.print(v + "\t");
        }
    }
}
