import java.util.*;
class containsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            if(m.containsKey(val)&&i-m.get(val)<=k)return true;
            m.put(val,i);
        }
        return false;
    }
}










// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         for(int i=0;i<nums.length-1;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[i]==nums[j] && Math.abs(i-j)<=k){
//                     // if(Math.abs(i-j)<=k)
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }