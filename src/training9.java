import java.math.BigInteger;

/**
 * Created by Orion on 2020/11/27 22:56
 */

//0-0
//1-1
//2-2
//3-3
//4-5
//5-8
/**
 *描述：
 * 小明是个非常无聊的人,他每天都会思考一些奇怪的问题,比如爬楼梯的时候,他就会想,如果每次可以上一级台阶或者两级台阶。那么上n级台阶一共有多少种方案?
 *
 * 斐波那契数列
 * 1.递归
 * 2.平推（循环）
 */

public class training9 {
    public static void main(String[] args) {
        int stairs=50;


        long startTime=System.currentTimeMillis();
        System.out.println("递归开始==="+startTime);

        System.out.println("fun=="+fun(stairs));

        long endTime=System.currentTimeMillis();
        System.out.println("递归结束==="+endTime);
        System.out.println("耗时==="+(endTime-startTime));


        startTime=System.currentTimeMillis();
        System.out.println("循环开始==="+startTime);
        System.out.println("fib=="+fibLoop(stairs+1));
        endTime=System.currentTimeMillis();
        System.out.println("循环结束==="+endTime);
        System.out.println("耗时==="+(endTime-startTime));
//        System.out.println("fibRec=="+fibRec(stairs));
    }

    public static long fun(int stairs){
        if (stairs==1){
            return 1;
        }else if (stairs==2){
            return 2;
        }else {
            return fun(stairs-1)+fun(stairs-2);
        }
    }
    //②==================================
    /**
     * 递归方法实现
     * f(n) = f(n - 1) + f(n - 2)
     * 最高支持 n = 92 ，否则超出 Long.MAX_VALUE
     * @param num n
     * @return f(n)
     */
    public static long fibRec(int num) {
        if(num < 1)
            return 0;
        if(num < 3)
            return 1;
        return fibRec(num - 1) + fibRec(num - 2);
    }

//①==================================
    /**
     * 平推方法实现
     */
    public static long fibLoop(int num) {
        if(num < 1 || num > 92)
            return 0;
        long a = 1;
        long b = 1;
        long temp;
        for(int i = 3; i <= num; i++) {
            temp = a;
            a = b;
            b += temp;
        }
        return b;
    }

}
