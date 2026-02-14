package zoho;

import java.util.Scanner;

public class a1b10 {
    public static void main(String acas[]){
        Scanner s=new Scanner(System.in);
        String input=s.next();
        int n=input.length();
        char var=input.charAt(0);//
        for(int i=1;i<n;i++){
            if(!Character.isDigit(input.charAt(i))){
                var=input.charAt(i);
            }else{
            int times=input.charAt(i)-'0';
            if(i+1<n&&Character.isDigit(input.charAt(i+1))){
                times=(times*10)+input.charAt(i+1)-'0';
                i++;
            }
            for(int j=0;j<times;j++){
                System.out.print(var);
            }
        }
        }
    }
}
