package training11;


/**
 * Created by Orion on 2021/1/20 16:06
 */

//链接：https://www.nowcoder.com/questionTerminal/9bac7c75c8254743a0c4910deebd198c
//        来源：牛客网
//
//        [编程题]统计岛屿的数量
//        热度指数：174时间限制：C/C++ 1秒，其他语言2秒空间限制：C/C++ 256M，其他语言512M
//        算法知识视频讲解
//        一个n*m的地图上，有一些位置是陆地、一些位置是海洋。地图之外则全部被海洋所包围。求地图中岛屿的数量。
//        地图中用 ‘x’  字符表示陆地，  '.' 字符表示海洋
//        注：对于坐标为(x,y)的陆地，它仅与坐标为(x+1,y)、(x-1,y)、(x,y+1)、(x,y-1)这四个坐标的陆地相邻时才看作它们是相连的。斜方向不认为是相连的。
//        示例1
//        输入
//        [".xx..","...xx",".xxx.","x...x"]
//        输出
//        4
//
//        备注:
//        地图的长和宽均不大于1000

import java.util.*;


public class Solution2 {

    public static void main(String[] args) {
        String[] TC={".xx..","...xx",".xxx.","x...x"};

        Solution2 s2=new Solution2();
                s2.solve(TC);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算岛屿的数量
     * @param Map string字符串一维数组 表示地图。
     * @return int整型
     */
    public int solve (String[] Map) {
        int flag=0;
        for (int row = 0; row < Map.length; row++) {
            for (int col = 0; col < Map[0].length(); col++) {
                if (Map[row].charAt(col)=='x'){
                    flag++;
                    dfs(Map,row,col);
                }
            }
        }
        return flag;
    }

    private void dfs(String[] map, int row, int col) {
        if (row<0||col<0||row>=map.length||col>=map[0].length()||map[row].charAt(col)=='.')return;

        StringBuffer tempBuffer =new StringBuffer(map[row]);
        tempBuffer.setCharAt(col,'.');
        map[row]=tempBuffer.toString();
        //深度优先搜索
        dfs(map,row-1,col);
        dfs(map,row+1,col);
        dfs(map,row,col-1);
        dfs(map,row,col+1);
    }
}
