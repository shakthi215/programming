// Example 1:


// Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
// Output: 7
// Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
// Example 2:

// Input: grid = [[1,2,3],[4,5,6]]
// Output: 12


class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i-1][0];
        }
        
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j-1];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        
        return grid[m-1][n-1];
    }
}


// class Solution {
//     public int minPathSum(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int dp[][] = new int[n][m];
//         for(int arr[]:dp){
//             Arrays.fill(arr,-1);
//         }
//         return helper(n-1,m-1,dp,grid);
//     }
//         public int helper(int i,int j,int dp[][],int grid[][]){
//         if(i==0 && j ==0) return grid[0][0];
//         if(i<0 || j<0) return (int)1e9;
//         if(dp[i][j] != -1) return dp[i][j];

//         int up = grid[i][j] + helper(i-1,j,dp,grid);
//         int left = grid[i][j] + helper(i,j-1,dp,grid);
//         dp[i][j] = Math.min(up,left);
//         return dp[i][j];
//     }
// }