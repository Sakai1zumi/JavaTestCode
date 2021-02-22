package arrayexer;

import org.junit.Test;

import java.util.Scanner;

/**
 * 回形数格式方阵的实现
 * 从键盘输入一个整数（1~20）
 * 则以该数字为矩阵的大小，把1,2,3…n*n 的数字按照顺时针螺旋的形式填入其中。
 * 例如： 输入数字2，则程序输出：
 * 1 2
 * 4 3
 * 输入数字3，则程序输出：
 * 1 2 3
 * 8 9 4
 * 7 6 5
 * 输入数字4， 则程序输出：
 * 1   2   3   4
 * 12  13  14  5
 * 11  16  15  6
 * 10   9  8   7
 *
 * @author TuHong
 * @create 2021-02-22 15:18
 */
public class exer02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数字：");
        int len = scanner.nextInt();
        int s = len * len;

        int[][] arr = new int[len][len];

        /*
        k=1：向右；k=2：向下；k=3：向左；k=4：向上
         */
        int k = 1;
        int i = 0,j = 0;
        for(int t = 1;t <= s; t++){
            //向右填充
            if(k == 1){
                if(j < len && arr[i][j] == 0){
                    arr[i][j] = t;
                    j++;
                }else{
                    k = 2;
                    i++;
                    j--;
                    t--;
                }
            }else if(k == 2){
                if(i < len && arr[i][j] == 0){
                    arr[i][j] = t;
                    i++;
                }else{
                    k = 3;
                    i--;
                    j--;
                    t--;
                }
            }else if(k == 3){
                if(j >= 0 && arr[i][j] == 0){
                    arr[i][j] = t;
                    j--;
                }else{
                    k = 4;
                    i--;
                    j++;
                    t--;
                }
            }else if(k == 4){
                if(i >= 0 && arr[i][j] == 0){
                    arr[i][j] = t;
                    i--;
                }else{
                    k = 1;
                    i++;
                    j++;
                    t--;
                }
            }
        }
        //遍历
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
