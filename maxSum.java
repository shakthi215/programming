// Example 1:

// Input: nums = [1,2,3,4,5]

// Output: 15

// Explanation:

// Select the entire array without deleting any element to obtain the maximum sum.

// Example 2:

// Input: nums = [1,1,0,1,1]

// Output: 1

// Explanation:

// Delete the element nums[0] == 1, nums[1] == 1, nums[2] == 0, and nums[3] == 1. Select the entire array [1] to obtain the maximum sum.

// Example 3:

// Input: nums = [1,2,-1,-2,1,0,-1]

// Output: 3

// Explanation:

// Delete the elements nums[2] == -1 and nums[3] == -2, and select the subarray [2, 1] from [1, 2, 1, 0, -1] to obtain the maximum sum.

 

import java.util.*;
class Solution {

    public int maxSum(int[] nums) {
        Set<Integer> positiveNumsSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                positiveNumsSet.add(num);
            }
        }
        if (positiveNumsSet.isEmpty()) {
            return Arrays.stream(nums).max().getAsInt();
        }
        return positiveNumsSet.stream().mapToInt(Integer::intValue).sum();
    }
}



// class Solution {
//     public int maxSum(int[] nums) {
//         Arrays.sort(nums);
//         int prev = nums[nums.length - 1];
//         int sum = prev;
//         for (int i = nums.length - 2; i >= 0; i--) {
//             int n = nums[i];
//             if (n <= 0) {
//                 return sum;
//             } else if (n != prev) {
//                 sum = sum + n;
//             }
//             prev = n;
//         }
//         return sum;
//     }
// }