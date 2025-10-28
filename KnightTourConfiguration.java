import java.util.Arrays;

public class KnightTourConfiguration {
    private static final int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    // Static method to solve the Knight's Tour problem
    public static boolean solveTour(int N, int[][] board) {
        for (int[] row : board) Arrays.fill(row, -1);  // Initialize the board with -1
        board[0][0] = 0;  // Start at position (0, 0)
        return backtrack(board, 0, 0, 1, N);  // Start the backtracking process
    }

    // Static method to perform backtracking
    private static boolean backtrack(int[][] board, int x, int y, int move, int N) {
        if (move == N * N) return true;  // If all squares are covered, the tour is complete
        for (int i = 0; i < 8; i++) {  // Try all 8 possible moves
            int nx = x + dx[i], ny = y + dy[i];
            if (isSafe(nx, ny, board, N)) {  // Check if the next move is safe
                board[nx][ny] = move;  // Make the move
                if (backtrack(board, nx, ny, move + 1, N)) return true;  // Continue the tour
                board[nx][ny] = -1;  // Undo the move (backtrack)
            }
        }
        return false;  // No valid move found
    }

    // Static method to check if the next move is within bounds and not visited
    private static boolean isSafe(int x, int y, int[][] board, int N) {
        return x >= 0 && y >= 0 && x < N && y < N && board[x][y] == -1;
    }

    // Static method to print the board
    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }

    // Main function to run the program
    public static void main(String[] args) {
        int N = 8;  // Size of the chessboard (8x8)
        int[][] board = new int[N][N];
        
        if (solveTour(N, board)) {
            System.out.println("Solution found!");
            printBoard(board);  // Print the solution if found
        } else {
            System.out.println("No solution exists.");
        }
    }
}






// public class Solution {
//     public boolean checkValidGrid(int[][] grid) {
//         int n = grid.length;
        
//         // Directions a knight can move: (x, y) offsets
//         int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
//         int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};
        
//         // Create an array to store the position of each number in the grid
//         int[][] pos = new int[n * n][2]; // Store (row, col) positions for numbers 0 to n*n-1
        
//         // Fill the position map with the coordinates of each number
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 pos[grid[i][j]] = new int[]{i, j};  // Store position of each number
//             }
//         }

//         // Check each move in sequence
//         for (int num = 0; num < n * n - 1; num++) {
//             // Find the position of the current number and next number
//             int[] current = pos[num];
//             int[] next = pos[num + 1];
            
//             // Check if the move is valid
//             boolean validMove = false;
//             for (int i = 0; i < 8; i++) {
//                 int newX = current[0] + dx[i];
//                 int newY = current[1] + dy[i];
//                 if (newX == next[0] && newY == next[1]) {
//                     validMove = true;
//                     break;
//                 }
//             }
            
//             // If the move is not valid, return false
//             if (!validMove) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         Solution solution = new Solution();

//         // Test case 1: Valid configuration
//         int[][] grid1 = {
//             {0, 11, 16, 5, 20},
//             {17, 4, 19, 10, 15},
//             {12, 1, 8, 21, 6},
//             {3, 18, 23, 14, 9},
//             {24, 13, 2, 7, 22}
//         };
//         System.out.println(solution.checkValidGrid(grid1));  // Output: true

//         // Test case 2: Invalid configuration
//         int[][] grid2 = {
//             {0, 3, 6},
//             {5, 8, 1},
//             {2, 7, 4}
//         };
//         System.out.println(solution.checkValidGrid(grid2));  // Output: false
//     }
// }
