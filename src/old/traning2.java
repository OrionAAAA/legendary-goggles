package old;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Orion on 2020/8/23 20:06
 */
public class traning2 {
    public void fun(){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        System.out.println("k==="+k);
        StringBuilder str=new StringBuilder();
        scanner.nextLine();

        for(int i=0;i<n;i++){
            if(i==k-1){
                scanner.next();
            }else {
                str.append(scanner.next()+" ");
            }
        }
        System.out.println(str);
        scanner.close();
    }
    }

