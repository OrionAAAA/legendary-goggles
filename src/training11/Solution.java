package training11;
import java.util.*;
/**
 * Created by Orion on 2021/1/20 14:25
 */
//链接：https://www.nowcoder.com/questionTerminal/0c9664d1554e466aa107d899418e814e
//        来源：牛客网
//
//        [编程题]岛屿数量
//        热度指数：15807时间限制：C/C++ 1秒，其他语言2秒空间限制：C/C++ 256M，其他语言512M
//        算法知识视频讲解
//        给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
//        岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
//        示例1
//        输入
//        [[1,1,0,0,0],[0,1,0,1,1],[0,0,0,1,1],[0,0,0,0,0],[0,0,1,1,1]]
//        输出
//        3
public class Solution {

//    static char [][] TEST_CASE1={{1,1,0,0,0},{0,1,0,1,1},{0,0,0,1,1},{0,0,0,0,0},{0,0,1,1,1}};
//    public static void old.main(String[] args) {
//        System.out.println(solve(TEST_CASE1));
//    }
    /**
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] grid) {
        int flag=0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col]=='1'){
                    flag++;
                    dfs(grid,row,col);
                }
            }
        }
        return flag;
    }
    public void dfs(char[][] grid,int row,int col){
        if (!(row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col] == '0')) {
            grid[row][col] = '0';
            dfs(grid, row - 1, col);
            dfs(grid, row + 1, col);
            dfs(grid, row, col - 1);
            dfs(grid, row, col + 1);
        }
    }
}


