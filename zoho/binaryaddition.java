package zoho;

import java.util.Scanner;

public class binaryaddition {
     public static void main(String acas[]){
        int a=10,b=15;
        while(b!=0){
            int carry=(a&b)<<1;
            a=a^b;
            b=carry;
        }
        System.out.print(a);
     }

    }