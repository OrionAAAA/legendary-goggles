import java.util.ArrayList;
import java.util.List;

/**
 * Created by Orion on 2020/9/14 21:43
 */
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
