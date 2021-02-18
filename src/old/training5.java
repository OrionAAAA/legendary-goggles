package old;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Orion on 2020/9/14 21:43
 */
//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
//        相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
//
//         
//
//        例如，给定三角形：
//
//        [
//        [2],
//        [3,4],
//        [6,5,7],
//        [4,1,8,3]
//        ]
//        自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//         
//
//        说明：
//
//        如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/triangle
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class training5 {
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int min=1000;
//        for(int i=0;i<Math.pow(2,triangle.size()-1);i++){
//            int total=0;
//            int pointer=0;
////            String bin=toBinary(i,triangle.size());
//            for(int j=0;j<triangle.size();j++){
//                if(bin.charAt(j)=='1') {
//                    pointer++;
//                }
//                total=total+triangle.get(j).get(pointer);
//                // System.out.println("pointer"+pointer);
//                // System.out.println("total"+total);
//            }
//            if(total<min) min=total;
//        }
//        return min;
//    }
////    public static List<String> findPath(int cengshu){
////        List<String> path=new ArrayList<>();
////        for (int i=0;i<Math.pow(2,cengshu-1);i++){
////            path.add(toBinary(i,cengshu));
////            //    System.out.println(toBinary(i,cengshu));
////        }
////        // System.out.println(path);
////        return path;
////    }
//
//    /**
//     * 将一个int数字转换为二进制的字符串形式。
//     * @param num 需要转换的int类型数据
//     * @param digits 要转换的二进制位数，位数不足则在前面补0
//     * @return 二进制的字符串形式
//     */
//    public static String toBinary(int num, int digits) {
//        int value = 1 << digits | num;
//        String bs = Integer.toBinaryString(value); //0x20 | 这个是为了保证这个string长度是6位数
//        return  bs.substring(1);
//    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
}
