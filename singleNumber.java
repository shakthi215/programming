import java.util.*;
class singleNumber {
    public int singleNumber1(int[] nums) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i:nums){
            m.put(i,m.getOrDefault(i,0)+1);
        }
        for(int i:nums){
            if(m.get(i)==1)return i;
        }
        return -1;
    }
}


// class Solution {
//     public int singleNumber(int[] nums) {
//         int res = 0;

//         for (int n : nums) {
//             res ^= n;
//         }

//         return res;        
//     }
// }