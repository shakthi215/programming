// 2148. Count Elements With Strictly Smaller and Greater Elements 
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given an integer array nums, return the number of elements that have both a strictly smaller and a strictly greater element appear in nums.

 

// Example 1:

// Input: nums = [11,7,2,15]
// Output: 2
// Explanation: The element 7 has the element 2 strictly smaller than it and the element 11 strictly greater than it.
// Element 11 has element 7 strictly smaller than it and element 15 strictly greater than it.
// In total there are 2 elements having both a strictly smaller and a strictly greater element appear in nums.
// Example 2:

// Input: nums = [-3,3,3,90]
// Output: 2
// Explanation: The element 3 has the element -3 strictly smaller than it and the element 90 strictly greater than it.
// Since there are two elements with the value 3, in total there are 2 elements having both a strictly smaller and a strictly greater element appear in nums.



class Solution {
    public int countElements(int[] nums) {
        int ans=0;
        for(int i:nums){
            int h=0,l=0;
            for(int j:nums){
                if(i>j){
                    l=1;
                }else if(i<j){
                    h=1;
                } 
            }
            if(l==1&&h==1)ans++;
        }
        return ans;
    }
}




// class Solution {
//     public int countElements(int[] nums) {
//         int n = nums.length;
//         int eleSmaller = Integer.MAX_VALUE;
//         int eleGreater = Integer.MIN_VALUE;
//         int count = 0;
//         for(int i=0;i<n;i++){
//             eleSmaller = Math.min(eleSmaller, nums[i]);
//             eleGreater = Math.max(eleGreater, nums[i]);
//         }
//         for(int i=0;i<n;i++){
//             if (nums[i] > eleSmaller && nums[i] < eleGreater){
//                 count++;
//             }
//         }
//         return count;
//     }
// }




// class Solution {
//     public int countElements(int[] nums) {
//         int count = 0;
//         int n = nums.length;
//         int min = 1000000;
//         int max = -1000000;
//         for ( int num : nums ) {
//             min = Math.min(min, num);
//             max = Math.max(max, num);
//         }
//         for ( int num : nums ) {
//             count += (num > min && num < max) ? 1 : 0;
//         }
//         return count;
//     }
// }




// class Solution {
//     public int countElements(int[] nums) {
//         int i,c=0;
//         Arrays.sort(nums);
//         int min=nums[0];
//         int max=nums[nums.length-1];

//         for(i=0;i<nums.length;i++)
//         {
//             if(nums[i]>min&&nums[i]<max)
//             {
//                 c++;
//             }
//         }
//         return c;
//     }
// }




// class Solution {
//   public int countElements(int[] nums) {
//     final int mn = Arrays.stream(nums).min().getAsInt();
//     final int mx = Arrays.stream(nums).max().getAsInt();
//     return (int) Arrays.stream(nums).filter(num -> mn < num && num < mx).count();
//   }
// }

