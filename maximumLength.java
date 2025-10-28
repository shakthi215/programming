// Example 1:

// Input: nums = [1,2,3,4]

// Output: 4

// Explanation:

// The longest valid subsequence is [1, 2, 3, 4].

// Example 2:

// Input: nums = [1,2,1,1,2,1,2]

// Output: 6

// Explanation:

// The longest valid subsequence is [1, 2, 1, 2, 1, 2].

// Example 3:

// Input: nums = [1,3]

// Output: 2

// Explanation:

// The longest valid subsequence is [1, 3].




class Solution {

    public int maximumLength(int[] nums) {
        int res = 0;
        int[][] patterns = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
        for (int[] pattern : patterns) {
            int cnt = 0;
            for (int num : nums) {
                if (num % 2 == pattern[cnt % 2]) {
                    cnt++;
                }
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}



// class Solution {
//     public int maximumLength(int[] nums) {
//         int[] count = new int[2]; 
//         int[] end = new int[2];   

//         for (int num : nums) {
//             int parity = num % 2;
//             count[parity]++;
//             end[parity] = end[1 - parity] + 1;
//         }

//         return Math.max(
//             Math.max(count[0], count[1]),
//             Math.max(end[0], end[1])
//         );
//     }
// }