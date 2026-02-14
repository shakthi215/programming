package zoho;

public class question2 {
    public static void main(String acas[]){
        String s="a1b2c34c3b2cb3a1d";
        char[] arr=s.toCharArray();
        int n=arr.length;

        int ind=0;
        for(int i=0;i<n;i++){
            char ch=arr[i];
            if(ch>='a'&&ch<='z'){
                boolean seenbefore=false;
                for(int j=0;j<i;j++){
                    if(ch==arr[j]){
                        seenbefore=true;
                        break;
                    }
                }
                if(!seenbefore){
                    arr[ind++]=ch;
                }
            }else if(ch>='0'&&ch<='9'){
                boolean a=false;
                for(int j=i+1;j<n;j++){
                    if(ch==arr[j]){
                        a=true;
                        break;
                    }
                }
                if(!a)arr[ind++]=ch;
            }
        }
        for(int i=0;i<ind;i++){
            System.out.print(arr[i]);
        }
    }
}
