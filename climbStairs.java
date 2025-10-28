// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// Example 2:

// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step





class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}



// class Solution {
//     public int climbStairs(int n) {
//         if (n == 0 || n == 1) {
//             return 1;
//         }
//         return climbStairs(n-1) + climbStairs(n-2);
//     }
// }



// class Solution {
//     public int climbStairs(int n) {
//         Map<Integer, Integer> memo = new HashMap<>();
//         return climbStairs(n, memo);
//     }
    
//     private int climbStairs(int n, Map<Integer, Integer> memo) {
//         if (n == 0 || n == 1) {
//             return 1;
//         }
//         if (!memo.containsKey(n)) {
//             memo.put(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
//         }
//         return memo.get(n);
//     }
// }




// class Solution {
//     public int climbStairs(int n) {
//         if (n == 0 || n == 1) {
//             return 1;
//         }
//         int prev = 1, curr = 1;
//         for (int i = 2; i <= n; i++) {
//             int temp = curr;
//             curr = prev + curr;
//             prev = temp;
//         }
//         return curr;
//     }
// }