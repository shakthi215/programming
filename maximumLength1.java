// Example 1:

// Input: nums = [1,2,3,4,5], k = 2

// Output: 5

// Explanation:

// The longest valid subsequence is [1, 2, 3, 4, 5].

// Example 2:

// Input: nums = [1,4,2,3,1,4], k = 3

// Output: 4

// Explanation:

// The longest valid subsequence is [1, 4, 1, 4].



class Solution {

    public int maximumLength1(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            num %= k;
            for (int i = 0; i < k; i++) {
                dp[i][num] = dp[num][i] + 1;
                res = Math.max(res, dp[i][num]);
            }
        }
        return res;
    }
}