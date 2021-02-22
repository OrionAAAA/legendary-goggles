package training20210221;

import java.util.HashSet;

/**
 * Created by Orion on 2021/2/21 14:34
 */
//给定两个数组，编写一个函数来计算它们的交集。
//
//         
//
//        示例 1：
//
//        输入：nums1 = [1,2,2,1], nums2 = [2,2]
//        输出：[2]
//        示例 2：
//
//        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//        输出：[9,4]
//         
//
//        说明：
//
//        输出结果中的每个元素一定是唯一的。
//        我们可以不考虑输出结果的顺序。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet set1= new HashSet();
        HashSet set2= new HashSet();
        int[] result={};
        for (int i : nums1) {
            if (!set1.contains(i)){
                set1.add(i);
            }
        }
        for (int i : nums2) {
            if (!set2.contains(i)){
                set2.add(i);
                if (set1.contains(i)){
                    int[] b={i};
                    int [] temp=new int[result.length+1];
                    System.arraycopy(result, 0, temp, 0, result.length);
                    System.arraycopy(b,0,temp,temp.length-1,1);
                    result=temp;
                }
            }

        }

        return result;
    }
}
