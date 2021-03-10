package training20210310;

import java.util.Scanner;

/**
 * Created by Orion on 2021/3/10 18:10
 */
//[编程题]压缩算法
//时间限制：C/C++ 2秒，其他语言4秒
//
//空间限制：C/C++ 256M，其他语言512M
//
//小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
//
//输入描述:
//输入第一行包含一个字符串s，代表压缩后的字符串。
//S的长度<=1000;
//S仅包含大写字母、[、]、|;
//解压后的字符串长度不超过100000;
//压缩递归层数不超过10层;
//
//输出描述:
//输出一个字符串，代表解压后的字符串。
//
//输入例子1:
//HG[3|B[2|CA]]F
//
//输出例子1:
//HGBCACABCACABCACAF
//
//例子说明1:
//HG[3|B[2|CA]]F−>HG[3|BCACA]F−>HGBCACABCACABCACAF
public class training {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StringBuilder s=new StringBuilder(scanner.nextLine());
        scanner.close();
        System.out.println("startTime"+System.currentTimeMillis());
        while (s.indexOf("]")!=-1) {

            int end = s.indexOf("]");
            int start = s.lastIndexOf("[",end);
            int mid = s.lastIndexOf("|",end);
            int times = Integer.parseInt(s.substring(start + 1, mid));
            String str = s.substring(mid + 1, end);
            StringBuilder newSB = new StringBuilder();
            for (int i = 0; i < times; i++) {
                newSB.append(str);
            }
            s.replace(start, end + 1, newSB.toString());
        }
        System.out.println(s);
        System.out.println("endTime"+System.currentTimeMillis());
    }
}
