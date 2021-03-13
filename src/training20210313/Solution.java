package training20210313;

import java.util.regex.Pattern;

/**
 * Created by Orion on 2021/3/13 22:54
 */
//394. 字符串解码
//给定一个经过编码的字符串，返回它解码后的字符串。
//
//编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
//你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
//此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//
//
//
//示例 1：
//
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
//示例 2：
//
//输入：s = "3[a2[c]]"
//输出："accaccacc"
//示例 3：
//
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
//示例 4：
//
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 执行结果：
//通过
//显示详情
//执行用时：
//10 ms
//, 在所有 Java 提交中击败了
//6.17%
//的用户
//内存消耗：
//37.3 MB
//, 在所有 Java 提交中击败了
//8.64%
//的用户

public class Solution {
    public static String decodeString(String s) {
        while (s.indexOf("]")!=-1) {
            int end = s.indexOf("]");
            int start = s.lastIndexOf("[",end);
            int times=0;
            for (int i = start-1; i >= 0; i--) {
                Pattern pattern = Pattern.compile("\\D");
                if (pattern.matcher(String.valueOf(s.charAt(i))).matches()) {
                    times=Integer.parseInt(s.substring(i+1,start));
                    break;
                }else if (i==0){
                    times=Integer.parseInt(s.substring(0,start));
                    break;
                }
            }

            String str = s.substring(start+1, end);
            StringBuilder newSB = new StringBuilder();
            for (int i = 0; i < times; i++) {
                newSB.append(str);
            }
            String oldStr=times+"["+str+"]";
            s=s.replace(oldStr,newSB);
        }
        return s;
    }

    public static void main(String[] args) {
        decodeString("3[a]2[bc]");
    }
}
