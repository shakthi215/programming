// Example 1:

// Input: n = 11, firstPlayer = 2, secondPlayer = 4
// Output: [3,4]
// Explanation:
// One possible scenario which leads to the earliest round number:
// First round: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
// Second round: 2, 3, 4, 5, 6, 11
// Third round: 2, 3, 4
// One possible scenario which leads to the latest round number:
// First round: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
// Second round: 1, 2, 3, 4, 5, 6
// Third round: 1, 2, 4
// Fourth round: 2, 4
// Example 2:

// Input: n = 5, firstPlayer = 1, secondPlayer = 5
// Output: [1,1]
// Explanation: The players numbered 1 and 5 compete in the first round.
// There is no way to make them compete in any other round.


// class Solution {

//     private int[][][] F = new int[30][30][30];
//     private int[][][] G = new int[30][30][30];

//     private int[] dp(int n, int f, int s) {
//         if (F[n][f][s] != 0) {
//             return new int[] { F[n][f][s], G[n][f][s] };
//         }
//         if (f + s == n + 1) {
//             return new int[] { 1, 1 };
//         }
//         // F(n,f,s) = F(n, n + 1 - s, n + 1 - f)
//         if (f + s > n + 1) {
//             int[] res = dp(n, n + 1 - s, n + 1 - f);
//             F[n][f][s] = res[0];
//             G[n][f][s] = res[1];
//             return new int[] { F[n][f][s], G[n][f][s] };
//         }

//         int earliest = Integer.MAX_VALUE;
//         int latest = Integer.MIN_VALUE;
//         int n_half = (n + 1) / 2;
//         if (s <= n_half) {
//             // On the left or in the middle
//             for (int i = 0; i < f; ++i) {
//                 for (int j = 0; j < s - f; ++j) {
//                     int[] res = dp(n_half, i + 1, i + j + 2);
//                     earliest = Math.min(earliest, res[0]);
//                     latest = Math.max(latest, res[1]);
//                 }
//             }
//         } else {
//             // s on the right
//             int s_prime = n + 1 - s;
//             int mid = (n - 2 * s_prime + 1) / 2;
//             for (int i = 0; i < f; ++i) {
//                 for (int j = 0; j < s_prime - f; ++j) {
//                     int[] res = dp(n_half, i + 1, i + j + mid + 2);
//                     earliest = Math.min(earliest, res[0]);
//                     latest = Math.max(latest, res[1]);
//                 }
//             }
//         }

//         F[n][f][s] = earliest + 1;
//         G[n][f][s] = latest + 1;
//         return new int[] { F[n][f][s], G[n][f][s] };
//     }

//     public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
//         // F(n,f,s) = F(n,s,f)
//         if (firstPlayer > secondPlayer) {
//             int temp = firstPlayer;
//             firstPlayer = secondPlayer;
//             secondPlayer = temp;
//         }

//         int[] res = dp(n, firstPlayer, secondPlayer);
//         return new int[] { res[0], res[1] };
//     }
// }


//more efficent


class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int p1 = Math.min(firstPlayer, secondPlayer);
        int p2 = Math.max(firstPlayer, secondPlayer);
        if (p1 + p2 == n + 1) {
            // p1 and p2 compete in the first round
            return new int[]{1, 1};
        }
        if (n == 3 || n == 4) {
            // p1 and p2 must compete in the second round (only two rounds).
            return new int[]{2, 2};
        }

        // Flip to make p1 be more closer to left than p2 to right end for convenience
        if (p1 - 1 > n - p2) {
            int t = n + 1 - p1;
            p1 = n + 1 - p2;
            p2 = t;
        }

        int m = (n + 1) / 2;
        int min = n;
        int max = 1;
        if (p2 * 2 <= n + 1) {
            // p2 is in the first half (n odd or even) or exact middle (n odd)
            int a = p1 - 1;
            int b = p2 - p1 - 1;
            // i represents the number of front players in A wins
            // j represents the number of front players in B wins
            for (int i = 0; i <= a; i++) {
                for (int j = 0; j <= b; j++) {
                    int[] ret = earliestAndLatest(m, i + 1, i + j + 2);
                    min = Math.min(min, 1 + ret[0]);
                    max = Math.max(max, 1 + ret[1]);
                }
            }
        } else {
            // p2 is in the later half (and has >= p1 distance to the end)
            int p4 = n + 1 - p2;
            int a = p1 - 1;
            int b = p4 - p1 - 1;
            // Group C are players between p4 and p2, (c+1)/2 will advance to the next round.
            int c = p2 - p4 - 1;
            for (int i = 0; i <= a; i++) {
                for (int j = 0; j <= b; j++) {
                    int[] ret = earliestAndLatest(m, i + 1, i + j + 1 + (c + 1) / 2 + 1);
                    min = Math.min(min, 1 + ret[0]);
                    max = Math.max(max, 1 + ret[1]);
                }
            }
        }
        return new int[]{min, max};
    }
}