package zoho;

import java.util.Scanner;

public class basic {
    public static void main(String acas[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)arr[i]=s.nextInt();
        System.out.println("Hello "+n);
        for(int i=0;i<n;i++)System.out.println(arr[i]);
    }
}
