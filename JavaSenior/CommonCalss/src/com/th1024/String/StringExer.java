package com.th1024.String;

import org.junit.Test;

/**
 * String常见算法题目
 *
 * @author TuHong
 * @create 2021-01-28 10:05
 */
public class StringExer {

    /**
     * @description: 1. 模拟一个trim方法，去除字符串两端的空格
     * @param: [str]
     * @return: java.lang.String
     * @author TuHong
     * @date: 2021/1/28 11:21
     */
    public String MyTrim(String str){
        if(str != null){
            int start = 0;
            int end = str.length() - 1;

            while(start < end && str.charAt(start) == ' '){
                start++;
            }
            while(start < end && str.charAt(end) == ' '){
                end--;
            }
            if(str.charAt(start) == ' '){
                return "";
            }

            return str.substring(start,end + 1);
        }
        return null;
    }
    @Test
    public void test1(){
        String str1 = "  abc  def   ";
        String s = MyTrim(str1);
        System.out.println(s);
    }

    /**
     * @description: 2. 将一个字符串进行反转，将字符串中指定部分进行反转。比如"abcdefg"反转为"abcfedcg"
     * @param: [str, start, end]
     * @return: java.lang.String
     * @author TuHong
     * @date: 2021/1/28 12:13
     */
    //方式一：使用char[]
    public String MyReverse(String str,int start,int end){

        if(str != null){

            char[] arr = str.toCharArray();
            char temp;
            for (int i = start, j = end; i < j; i++,j--) {
                 temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            return new String(arr);
        }
        return null;
    }
    //方式二：使用String拼接
    public String MyReverse1(String str,int start,int end){
        if(str != null){
            //第一部分
            String reverseStr = str.substring(0,start);
            //第二部分
            for (int i = end; i >=start ; i--) {
                reverseStr += str.charAt(i);
            }
            //第三部分
            reverseStr += str.substring(end + 1);

            return reverseStr;
        }
        return null;
    }
    //方式三：使用StringBuffer/StringBuilder替换String
    public String MyReverse2(String str,int start,int end){

        if(str != null){
            StringBuilder builder = new StringBuilder(str.length());

            //第一部分
            builder.append(str.substring(0,start));
            //第二部分
            for (int i = end; i >= start; i--) {
                builder.append(str.charAt(i));
            }
            //第三部分
            builder.append(str.substring(end + 1));

            return builder.toString();
        }

        return null;
    }
    @Test
    public void test2(){
        String str2 = "abcdefg";
        String reverse = MyReverse2(str2, 2, 5);
        System.out.println(reverse);

    }

    /**
     * @description: 3. 获取一个字符串在另一个字符串中出现的次数。
     *              比如：获取"ab"在"abkkcadkabkebfkabkskab"中出现的次数
     * @param: [mainStr, subStr]
     * @return: int
     * @author TuHong
     * @date: 2021/1/28 14:25
     */
    public int getCount(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();

        if(mainLength >= subLength){
            int count = 0;
            int isExist = 0;
            //方式一
//            while((isExist = mainStr.indexOf(subStr))!= -1){
//                count ++;
//                mainStr = mainStr.substring(isExist + subLength);
//            }
            //方式二
            while((isExist = mainStr.indexOf(subStr,isExist)) != -1){
                count ++;
                isExist ++;
            }
            return count;
        }
        return 0;
    }
    @Test
    public void test3(){
        String str1 = "abkkcadkabkebfkabkskab";
        String str2 = "ab";
        System.out.println(getCount(str1,str2));
    }

    /*
    4. 获取两个字符串中最大相同子串。比如：
    str1 = "abcwerthelloyuiodef",str2 = "cvhellobnm"
    提示：将最短的那个穿进行长度依次递减的子串与较长的穿比较
     */
    //前提：两个字符串中只有一个最大相同子串
    public String getMaxSameString(String str1,String str2){
        if(str1 != null && str2 != null){
            String maxStr = (str1.length() >= str2.length())? str1 : str2;
            String minStr = (str1.length() < str2.length())? str1 : str2;
            int length = minStr.length();

            for(int i = 0;i < length;i++){

                for(int x = 0,y = length - i;y <= length;x++,y++){
                    String substring = minStr.substring(x, y);
                    if(maxStr.contains(substring)){
                        return minStr;
                    }
                }
            }
        }
        return null;
    }
    @Test
    public void test4(){
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";

        String maxSameString = getMaxSameString(str1, str2);

        System.out.println(maxSameString);
    }




}



