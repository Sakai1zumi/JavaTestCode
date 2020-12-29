package com.th1024.structure;

public class Demo04 {
    public static void main(String[] args) {
        //计算0-100之间奇数和偶数的和

        int i = 0;
        int sum1 = 0;
        int sum2 = 0;
        for(i=0;i<=100;i++){
            if(i%2!=0){
                sum1 += i;
            }else{
                sum2 += i;
            }
        }
        System.out.println("0-100之间的奇数和为："+sum1);
        System.out.println("0-100之间的偶数和为："+sum2);

    }
}
