package training20210122;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Orion on 2021/1/22 21:16
 */
//13. 罗马数字转整数
//        罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
//
//        字符          数值
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
//        例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
//
//        通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//        I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 IV IX
//        X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 XL XC
//        C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 CD CM
//        给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
public class training {
    public static void main(String[] args) {
        Solution s=new Solution();
        s.romanToInt("CMXCI");
    }
    static class Solution {
        Map<String, Integer> romanMap=new HashMap<>();

        private void initRomanMap(){
            romanMap.put("I",1);
            romanMap.put("V",5);
            romanMap.put("X",10);
            romanMap.put("L",50);
            romanMap.put("C",100);
            romanMap.put("D",500);
            romanMap.put("M",1000);
            romanMap.put("IV",4);
            romanMap.put("IX",9);
            romanMap.put("XL",40);
            romanMap.put("XC",90);
            romanMap.put("CD",400);
            romanMap.put("CM",900);
        }
        public int romanToInt(String s) {
            initRomanMap();
            int total=0;
            s=s+" ";
            for (int i = 0; i < s.length()-1; i++) {
                String letter=s.substring(i,i+2);
                System.out.println(letter);
                if (romanMap.get(letter)!=null){
                    s=s.replaceFirst(letter,"");
                    i--;
                    System.out.println("replace"+s);
                    total+=romanMap.get(letter);
                    System.out.println("total"+total);
                }
            }
            for (int i = 0; i < s.length()-1; i++) {
                String letter=String.valueOf(s.charAt(i));
                if (romanMap.get(letter)!=null) {
                    total += romanMap.get(letter);
                    System.out.println(letter);
                    System.out.println("total"+total);
                }
            }
            System.out.println(total);
            return total;
        }
    }
}
