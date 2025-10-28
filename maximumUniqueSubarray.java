// Example 1:

// Input: nums = [4,2,4,5,6]
// Output: 17
// Explanation: The optimal subarray here is [2,4,5,6].
// Example 2:

// Input: nums = [5,2,1,2,5,2,1,2,5]
// Output: 8
// Explanation: The optimal subarray here is [5,2,1] or [1,2,5].



import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int currentSum = 0;
        int maxSum = 0;
        int left = 0;
        Set<Integer> set = new HashSet<>();

        for (int right = 0; right < n; right++) {
            int num = nums[right];

            // If duplicate found, shrink from left until unique
            while (set.contains(num)) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            // Add new unique number
            set.add(num);
            currentSum += num;

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}



// class Solution {
//     public int maximumUniqueSubarray(int[] nums) {
//         int n = nums.length;
//         int count = 0;
//         int l = 0;
//         int max = 0;
//         int[] freq = new int[10001];
//         for(int r=0;r<n;r++){
//             int num = nums[r];            
//             while(freq[num] > 0){                
//                 freq[nums[l]]--;
//                 count-=nums[l];
//                 l++;
//             }
//             freq[num]++;
//             count+=num;
//             max = Math.max(max, count);       
//         }
//         return max;
//     }
// }