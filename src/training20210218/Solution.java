package training20210218;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Orion on 2021/2/18 17:41
 */
//解法1
//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        int [] result={0,0};
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (j==i){}
//                else {
//                    if (target-nums[i]==nums[j]) {
//                        result[0]=i;
//                        result[1]=j;
//                    }
//                }
//            }
//        }
//        return  result;
//    }
//}

//解法2
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}

//作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
