// Example 1:


// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]
// Example 2:


// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]



import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l=new ArrayList<>();
        int row=matrix.length;
        int col=matrix[0].length;
        int top=0,left=0;
        int bottom=row-1,right=col-1;
        while(top<=bottom&&left<=right){
            for(int i=left;i<=right;i++){
                // System.out.print(matrix[top][i]+" ");
                l.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                // System.out.print(matrix[i][right]+" ");
                l.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
            for(int i=right;i>=left;i--){
                // System.out.print(matrix[bottom][i]+" ");
                l.add(matrix[bottom][i]);
            }
            bottom--;
            }
             if(left<=right){
            for(int i=bottom;i>=top;i--){
                // System.out.print(matrix[i][left]+" ");
                l.add(matrix[i][left]);
            }
            left++;
        }
        }
        return l;
    }
}