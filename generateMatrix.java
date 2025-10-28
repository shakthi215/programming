// Example 1:


// Input: n = 3
// Output: [[1,2,3],[8,9,4],[7,6,5]]
// Example 2:

// Input: n = 1
// Output: [[1]]



class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        int top=0,left=0;
        int bottom=n-1,right=n-1;
        int a=1;
        while(top<=bottom&&left<=right){
            for(int i=left;i<=right;i++){
                ans[top][i]=a;
                a++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                ans[i][right]=a;
                a++;
            }
            right--;
            if(top<=bottom){
            for(int i=right;i>=left;i--){
                ans[bottom][i]=a;
                a++;
            }
            bottom--;
            }
            if(left<=right){
            for(int i=bottom;i>=top;i--){
                ans[i][left]=a;
                a++;
            }
            left++;
            }
        }
        return ans;
    }
}