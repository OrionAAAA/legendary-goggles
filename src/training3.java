import java.util.Scanner;

/**
 * Created by Orion on 2020/8/23 21:20
 */

public class training3 {
    public void fun() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            findSum(n);

        }
    }
        //数位和
        public int numSum(int num) {
            int sum = 0;
            do {
                sum += num % 10;
            } while ((num = num / 10) > 0);
            return sum;
        }

        public void findSum(int n){
            int a=0,b=0;
            int val=0;
            if(n%2==0){//偶数
                while(a!=n/2){
                    b=n-a;
                    int valA= numSum(a);
                    int valB=numSum(b);
                    int total=valA+valB;
                    if(total>val){
                        val=total;
                    }
                    a++;
                }
            }else {
                while(a!=n/2-1){
                    b=n-a;
                    int valA= numSum(a);
                    int valB=numSum(b);
                    int total=valA+valB;
                    if(total>val){
                        val=total;
                    }
                    a++;
                }
            }
            System.out.print("val=="+val);
        }
    }


