package zoho;

import java.util.Scanner;

public class pattern {
     public static void main(String acas[]){
        Scanner s=new Scanner(System.in);
        String input=s.next();
        int n=input.length();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    System.out.print(input.charAt(i)+" ");
                }else if(i+j==n-1){
                    System.out.print(input.charAt(i)+" ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

     }
}
