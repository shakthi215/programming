// Example 1:


// Input: n = 4
// Output: 2
// Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
// Example 2:

// Input: n = 1
// Output: 1
 


import java.util.*;
class Solution {
    public int totalNQueens(int n) {
        char[][] nQueens = new char[n][n];
        int output=0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        }
        return solveNQueens(n, output, nQueens, 0);
        // return output;
    }
    private boolean isSafePlace(int n, char[][] nQueens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (nQueens[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (nQueens[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (nQueens[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
    private int solveNQueens(int n, int output, char[][] nQueens, int row) {
        if (row == n) {
            // output++;
            return output+1;
        }

        for (int col = 0; col < n; col++) {
            if (isSafePlace(n, nQueens, row, col)) {
                nQueens[row][col] = 'Q';
                output=solveNQueens(n, output, nQueens, row + 1);
                nQueens[row][col] = '.';
            }
        }
        return output;
    }
}