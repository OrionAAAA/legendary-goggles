package training20210222;


/**
 * Created by Orion on 2021/2/22 22:23
 */
//7. 整数反转
//        给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
//
//        如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
//
//        假设环境不允许存储 64 位整数（有符号或无符号）。
//
//
//        示例 1：
//
//        输入：x = 123
//        输出：321
//        示例 2：
//
//        输入：x = -123
//        输出：-321
//        示例 3：
//
//        输入：x = 120
//        输出：21
//        示例 4：
//
//        输入：x = 0
//        输出：0
//
//
//        提示：
//
//        -231 <= x <= 231 - 1
class Solution {
    public static int reverse(int x) {
        String strResult="";
        if (x>=0) {
            String s= String.valueOf(x);
            String[] strArray = s.split("");
            for (int i = strArray.length-1; i >=0; i--) {
                strResult=strResult+strArray[i];
            }
            try{
                return Integer.valueOf(strResult);
            }catch (NumberFormatException e){
                return 0;
            }
        }
        else {
            x=-x;
            String s= String.valueOf(x);
            String[] strArray = s.split("");
            for (int i = strArray.length-1; i >=0; i--) {
                strResult=strResult+strArray[i];
            }
            try{
                return -Integer.valueOf(strResult);
            }catch (NumberFormatException e){
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
