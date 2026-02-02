import java.util.*;
class majorityElement {
    public int majorityElement1(int[] nums) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i:nums){
            m.put(i,m.getOrDefault(i,0)+1);
        }
        int max=Integer.MIN_VALUE;
        int ans=Integer.MIN_VALUE;
        for(int i:nums){
            if(max<m.get(i)){
                max=m.get(i);
                ans=i;
            }
        }
        return ans;
    }
}