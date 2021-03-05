package training2021035;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Orion on 2021/3/5 22:11
 */
//20. 有效的括号
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//
//
//示例 1：
//
//输入：s = "()"
//输出：true
//示例 2：
//
//输入：s = "()[]{}"
//输出：true
//示例 3：
//
//输入：s = "(]"
//输出：false
//示例 4：
//
//输入：s = "([)]"
//输出：false
//示例 5：
//
//输入：s = "{[]}"
//输出：true
//
//
//提示：
//
//1 <= s.length <= 104
//s 仅由括号 '()[]{}' 组成

//    执行结果：
//通过
//显示详情
//执行用时：
//7 ms
//, 在所有 Java 提交中击败了
//7.85%
//的用户
//内存消耗：
//36.9 MB
//, 在所有 Java 提交中击败了
//10.78%
//的用户

class Solution {
    public boolean isValid(String s) {
        List<Character> queue =new ArrayList<>();
        if (s.length()%2!=0){
            return false;
        }else {
            for (int i = 0; i < s.length(); i++) {
                char nowChar=s.charAt(i);
                if (nowChar=='('||nowChar=='{'||nowChar=='['){
                    queue.add(nowChar);
                }
                if (nowChar==')'||nowChar=='}'||nowChar==']'){
                    try{
                        if (queue.get(queue.size()-1)==nowChar-1||queue.get(queue.size()-1)==nowChar-2){
                            queue.remove(queue.size()-1);
                        }else return false;
                    }catch (IndexOutOfBoundsException e){
//                        e.printStackTrace();
                        return false;
                    }

                }
            }
            if (queue.size()!=0)return false;
            return true;
        }
    }

}
