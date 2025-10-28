// 2044. Count Number of Maximum Bitwise-OR Subsets
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different non-empty subsets with the maximum bitwise OR.

// An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two subsets are considered different if the indices of the elements chosen are different.

// The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).

 

// Example 1:

// Input: nums = [3,1]
// Output: 2
// Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
// - [3]
// - [3,1]
// Example 2:

// Input: nums = [2,2,2]
// Output: 7
// Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 23 - 1 = 7 total subsets.
// Example 3:

// Input: nums = [3,2,1,5]
// Output: 6
// Explanation: The maximum possible bitwise OR of a subset is 7. There are 6 subsets with a bitwise OR of 7:
// - [3,5]
// - [3,1,5]
// - [3,2,5]
// - [3,2,1,5]
// - [2,5]
// - [2,1,5]




class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        int[] dp = new int[1 << 17];
        dp[0]=1;
        for (int num : nums) {
            for (int i = max; i >= 0; i--) {
                dp[i | num] += dp[i];
            }
            max |= num;
        }
        return dp[max];
    }
}



// class Solution {
//     int count=0;
//     public int countMaxOrSubsets(int[] nums) {
//         int maxOr=0;
//         for(int a:nums) maxOr |= a;
//         backtrack(nums,maxOr,0,0);
//         return count;
//     }
//     void backtrack(int[] nums,int targetOr, int currOr,int index){
//         if(currOr==targetOr){
//             // for pruning the branches in backtracking
//             count = count + (1<<(nums.length-index));
//             return;
//         }
//         for(int i=index;i<nums.length;i++){
//             backtrack(nums,targetOr,currOr|nums[i],i+1);
//         }
//     }
// }




// class Solution {
//     public void backtrack(int[] nums, int index, int currentOR, int maxOR, int[] count) {
//         if (currentOR == maxOR) {
//             count[0]++;
//         }
//         for (int i = index; i < nums.length; i++) {
//             backtrack(nums, i + 1, currentOR | nums[i], maxOR, count);
//         }
//     }
//     public int countMaxOrSubsets(int[] nums) {
//         int maxOR = 0;
//         for (int num : nums) {
//             maxOR |= num;
//         }
//         int[] count = new int[1];
//         backtrack(nums, 0, 0, maxOR, count);
//         return count[0];
//     }
// }




// class Solution {
//      static int maxOr = 0;
//         static int count =0;
//     public int countMaxOrSubsets(int[] nums) {  
    

//             maxOr = 0;
//             count = 0;

//             for(int num:nums){
//                 maxOr|= num;
//             }

//             dfs(nums, 0, 0);
//             return count;
//         }
//         private static  void dfs(int [] nums,int index,int currentOr){
//             if(index== nums.length){
//                 if(currentOr==maxOr){
//                     count++;
//                 }
//                 return;
//             }
//             dfs(nums, index+1,currentOr|nums[index]);
//             dfs(nums,index+1, currentOr);
//         }
//     }




// class Solution {

//     public int countMaxOrSubsets(int[] nums) {
//         // Calculate the maximum possible OR value
//         int maxOrValue = 0;
//         for (int num : nums) {
//             maxOrValue |= num;
//         }

//         int totalSubsets = 1 << nums.length; // 2^n subsets
//         int subsetsWithMaxOr = 0;

//         // Iterate through all possible subsets
//         for (int subsetMask = 0; subsetMask < totalSubsets; subsetMask++) {
//             int currentOrValue = 0;

//             // Calculate OR value for the current subset
//             for (int i = 0; i < nums.length; i++) {
//                 if (((subsetMask >> i) & 1) == 1) {
//                     currentOrValue |= nums[i];
//                 }
//             }

//             // If current subset's OR equals maxOrValue, increment count
//             if (currentOrValue == maxOrValue) {
//                 subsetsWithMaxOr++;
//             }
//         }

//         return subsetsWithMaxOr;
//     }
// }



// class Solution {

//     public int countMaxOrSubsets(int[] nums) {
//         int n = nums.length;
//         int maxOrValue = 0;

//         // Calculate the maximum OR value
//         for (int num : nums) {
//             maxOrValue |= num;
//         }

//         Integer[][] memo = new Integer[n][maxOrValue + 1];

//         return countSubsetsRecursive(nums, 0, 0, maxOrValue, memo);
//     }

//     private int countSubsetsRecursive(
//         int[] nums,
//         int index,
//         int currentOr,
//         int targetOr,
//         Integer[][] memo
//     ) {
//         // Base case: reached the end of the array
//         if (index == nums.length) {
//             return (currentOr == targetOr) ? 1 : 0;
//         }

//         // Check if the result for this state is already memoized
//         if (memo[index][currentOr] != null) {
//             return memo[index][currentOr];
//         }

//         // Don't include the current number
//         int countWithout = countSubsetsRecursive(
//             nums,
//             index + 1,
//             currentOr,
//             targetOr,
//             memo
//         );

//         // Include the current number
//         int countWith = countSubsetsRecursive(
//             nums,
//             index + 1,
//             currentOr | nums[index],
//             targetOr,
//             memo
//         );

//         // Memoize and return the result
//         return memo[index][currentOr] = countWithout + countWith;
//     }
// }





// class Solution {

//     public int countMaxOrSubsets(int[] nums) {
//         int maxOrValue = 0;
//         for (int num : nums) {
//             maxOrValue |= num;
//         }
//         return countSubsets(nums, 0, 0, maxOrValue);
//     }

//     private int countSubsets(
//         int[] nums,
//         int index,
//         int currentOr,
//         int targetOr
//     ) {
//         // Base case: reached the end of the array
//         if (index == nums.length) {
//             return (currentOr == targetOr) ? 1 : 0;
//         }

//         // Don't include the current number
//         int countWithout = countSubsets(nums, index + 1, currentOr, targetOr);

//         // Include the current number
//         int countWith = countSubsets(
//             nums,
//             index + 1,
//             currentOr | nums[index],
//             targetOr
//         );

//         // Return the sum of both cases
//         return countWithout + countWith;
//     }
// }