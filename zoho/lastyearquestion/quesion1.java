package zoho.lastyearquestion;

import java.util.Scanner;

public class quesion1 {
     public static void main(String acas[]){
        Scanner s=new Scanner(System.in);
        String text=s.next();
        String pattern=s.next();
        for(int i=0;i<text.length();i++){
            int t=i;
            int p=0;
            while(t<text.length()&&p<pattern.length()){
                char pc=pattern.charAt(p);
                if(p+1<pattern.length()&&pattern.charAt(p+1)=='*'){
                    char prev=pc;
                    while(t<text.length()&&text.charAt(t)==prev){
                        t++;
                    }
                    p+=2;
                    
                }else if(p+1<pattern.length()&&pattern.charAt(p+1)=='+'){
                    char prev=pc;
                    int count=0;
                    while(t<text.length()&&text.charAt(t)==prev){
                        t++;
                        count++;
                    }
                    if(count==0)break;
                    p+=2;

                }else{
                    if(t<text.length()&&text.charAt(t)==pc){
                        t++;
                        p++;
                    }else{
                        break;
                    }
                }
            }
            if(p==pattern.length()){
                System.out.print(text.substring(i,t));
                break;
            }
        }

     } 
}
