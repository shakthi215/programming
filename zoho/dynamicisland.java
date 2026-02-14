package zoho;

public class dynamicisland {
    public static void main(String acas[]){
        int n = 5;
        int[][] queries = {
            {1,4},
            {3,2},
            {2,3},
            {4,5},
            {3,0}
        };
        int[] arr=new int[n];
        for(int q=0;q<queries.length;q++){
            int index=queries[q][0]-1;
            int value=queries[q][1];
            arr[index]=value;
            int cursum=0;
            int maxsum=0;
            for(int i=0;i<n;i++){
                if(arr[i]!=0){
                    cursum=Math.max(cursum+arr[i],arr[i]);
                    maxsum=Math.max(maxsum,cursum);
                }else{
                    cursum=0;
                }
            }
            System.out.println(maxsum);

        }
    }
}
