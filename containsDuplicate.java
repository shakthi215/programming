import java.util.*;
class containsDuplicate {
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> s=new HashSet<>();
        for(int i:nums)s.add(i);
        if(s.size()==nums.length)return false;
        else return true;
    }
}



// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Set<Integer> numSet = new HashSet<>();

//         for (int n : nums) {
//             if (numSet.contains(n)) {
//                 return true;
//             }
//             numSet.add(n);
//         }
        
//         return false;        
//     }
// }


// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Arrays.sort(nums);
        
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] == nums[i - 1]) {
//                 return true;
//             }
//         }
        
//         return false;        
//     }
// }