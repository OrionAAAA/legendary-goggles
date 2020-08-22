/**
 * Created by Orion on 2020/8/22 0:07
 */

import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

/**小Q想要给他的朋友发送一个神秘字符串，
 * 但是他发现字符串的过于长了，
 * 于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，
 * 对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，
 * 例如字符串ABCABCABC将会被压缩为[3|ABC]，
 * 现在小Q的同学收到了小Q发送过来的字符串，
 * 你能帮助他进行解压缩么？

        输入描述:
        输入第一行包含一个字符串s，代表压缩后的字符串。
        S的长度<=1000;
        S仅包含大写字母、[、]、|;
        解压后的字符串长度不超过100000;
        压缩递归层数不超过10层;

        输出描述:
        输出一个字符串，代表解压后的字符串。

        示例1
        输入
        HG[3|B[2|CA]]F

        输出
        HGBCACABCACABCACAF

        说明
        HG[3|B[2|CA]]F−>HG[3|BCACA]F−>HGBCACABCACABCACAF
 */
public class traning1 {
    public void fun(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println("scanner.next()===="+str);
        scanner.close();
        StringBuilder s = new StringBuilder(str);
        char c;
//        System.out.println("Azzz".matches("[a-zA-Z]*"));

        /**解法1: (较复杂)*/
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='|'){
                int pointer=i;
                int mid=pointer--;
                while (s.charAt(pointer)!='['&&s.charAt(pointer)!=']'&&s.charAt(pointer)!='|')pointer--;
                int left=pointer;
                int times=Integer.parseInt(s.substring(pointer+1,mid));
                pointer=mid+1;
                while (s.charAt(pointer)!='['&&s.charAt(pointer)!=']'&&s.charAt(pointer)!='|')pointer++;
                String word=s.substring(mid+1,pointer);
                StringBuilder newStr=new StringBuilder();
                for(int o=0;o<times;o++){
                    newStr.append(word);
                }
                s.replace(left,pointer, String.valueOf(newStr));
                i=left;
                System.out.println("i==="+i);
            }
        }
        System.out.println(s.toString().replaceAll("\\W",""));
/**解法2*/
//        for (int i = 0; i < s.length(); i++) {
//            c = s.charAt(i);
//            if (c == ']') {
//                int left = i, mid;
//                while (s.charAt(--left) != '|') ;
//                mid = left;
//                while (s.charAt(--left) != '[') ;
//                int times = Integer.parseInt(s.substring(left + 1, mid));
//                String newStr = s.substring(mid + 1, i);
//                newStr = String.join("", Collections.nCopies(times, newStr));
//
//                s.replace(left,i+1,newStr);
//                i = left;
//            }
//        }
//        System.out.println(s);
    }
}
