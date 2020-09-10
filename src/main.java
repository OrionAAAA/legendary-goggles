import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Orion on 2020/8/22 0:08
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  str=scanner.next();
        scanner.nextLine();
        int k=scanner.nextInt();

        if(k==1){
            char min='a';
            for (int i=0;i<str.length();i++){
                if (str.charAt(i)<=min) {
                    min=str.charAt(i);
                }
            }
            System.out.println(min);
        }else {
            int pointer=0;
            char kmin='a';
            for (int i=0;i<str.length();i++){
                if (str.charAt(i)<=kmin) {
                    kmin=str.charAt(i);
                    pointer++;
                }
                if (pointer==k)System.out.println(kmin);
            }
        }

//        for (int i=0;i<str.length();i++){
//
//        }
    }

}
