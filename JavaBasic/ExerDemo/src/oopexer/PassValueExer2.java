package oopexer;

/**
 * @author TuHong
 * @create 2021-02-23 11:12
 */
import java.util.Arrays;

public class PassValueExer2{
    public static void main(String[] args){
        int[] array = {3,2,5,1,7,6,12,8};

        //调用sort方法，实现从大到小排序
        //在此处补充代码
		PassValueExer2 exer = new PassValueExer2();
		exer.sort(array);

        //显示结果
        System.out.println("排序后的结果是：" + Arrays.toString(array));
    }

    //要求使用冒泡排序完成
    public void sort(int[] arr){
        boolean flag = false;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] < arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1]  = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
            flag = false;
        }
    }
}

