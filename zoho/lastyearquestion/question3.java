package zoho.lastyearquestion;

public class question3 {
    static int getindex(char ch){
        if(ch=='a')return 0;
        if(ch=='e')return 1;
        if(ch=='i')return 2;
        if(ch=='o')return 3;
        if(ch=='u')return 4;
        return -1;
    }
    public static void main(String acas[]){
        // String str="aaesdeaeeiohdufaaeeioou";
        // String word = "aeeeiiiioooauuuaeiou";
        String word="maeiaaioaaaaeziiiihouuuzooaauuaeiugn";


        int maxlen=0;
        int maxstart=-1;

        int start=0;
        int distinct=0;
        int lastindex=-1;

        for(int i=0;i<word.length();i++){

            int curr=getindex(word.charAt(i));
            if(curr!=-1){

                if(curr<lastindex){
                    start=i;
                    distinct=0;
                }
                if(curr!=lastindex){
                    distinct++;
                }
                lastindex=curr;
            }else{
                if(lastindex==4){
                    if(distinct==5){
                        int len=i-start;
                        if(len>maxlen){
                            maxlen=len;
                            maxstart=start;
                        }
                    }
                    distinct=0;
                    lastindex=-1;
                }
            }
            if(lastindex==4&&distinct==5){
                int len=i-start+1;
                if(len>maxlen){
                    maxlen=len;
                    maxstart=start;
                }
            }
        }
       
        if(maxlen==0)
            System.out.print("0");
        else
            System.out.print(word.substring(maxstart,maxlen+maxstart));
    }
}
