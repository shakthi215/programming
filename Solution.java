// Example 1:

// Input: nums = [3,1,2]
// Output: -1
// Explanation: Here, nums has 3 elements, so n = 1. 
// Thus we have to remove 1 element from nums and divide the array into two equal parts.
// - If we remove nums[0] = 3, the array will be [1,2]. The difference in sums of the two parts will be 1 - 2 = -1.
// - If we remove nums[1] = 1, the array will be [3,2]. The difference in sums of the two parts will be 3 - 2 = 1.
// - If we remove nums[2] = 2, the array will be [3,1]. The difference in sums of the two parts will be 3 - 1 = 2.
// The minimum difference between sums of the two parts is min(-1,1,2) = -1. 
// Example 2:

// Input: nums = [7,9,5,8,1,3]
// Output: 1
// Explanation: Here n = 2. So we must remove 2 elements and divide the remaining array into two parts containing two elements each.
// If we remove nums[2] = 5 and nums[3] = 8, the resultant array will be [7,9,1,3]. The difference in sums will be (7+9) - (1+3) = 12.
// To obtain the minimum difference, we should remove nums[1] = 9 and nums[4] = 1. The resultant array becomes [7,5,8,3]. The difference in sums of the two parts is (7+5) - (8+3) = 1.
// It can be shown that it is not possible to obtain a difference smaller than 1.


import java.util.*;
public class Solution {

    public long minimumDifference(int[] nums) {
        int n3 = nums.length;
        int n = n3 / 3;
        long[] part1 = new long[n + 1];
        long sum = 0;
        // max heap (simulate with opposite numbers)
        PriorityQueue<Integer> ql = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            ql.add(nums[i]);
        }
        part1[0] = sum;
        for (int i = n; i < n * 2; ++i) {
            sum += nums[i];
            ql.add(nums[i]);
            sum -= ql.poll();
            part1[i - (n - 1)] = sum;
        }

        long part2 = 0;
        // min heap
        PriorityQueue<Integer> qr = new PriorityQueue<>();
        for (int i = n * 3 - 1; i >= n * 2; --i) {
            part2 += nums[i];
            qr.add(nums[i]);
        }
        long ans = part1[n] - part2;
        for (int i = n * 2 - 1; i >= n; --i) {
            part2 += nums[i];
            qr.add(nums[i]);
            part2 -= qr.poll();
            ans = Math.min(ans, part1[i - n] - part2);
        }
        return ans;
    }
}



// class Solution {
//     public long minimumDifference(int[] nums) {
        
//         long[] leftMins = new long[nums.length];
//         long[] rightMaxs = new long[nums.length];

//         int n = nums.length;
//         int oneThird = n/3;
//         PriorityQueue<Integer> pqMin = new PriorityQueue<>(new Comparator<Integer>(){
//             public int compare(Integer a, Integer b) {
//                 return b-a;
//             }
//         });
//         PriorityQueue<Integer> pqMax = new PriorityQueue<>();
//         long minSum = 0;
//         long maxSum = 0;
//         long ret = Long.MAX_VALUE;


//         for (int i = 0; i < oneThird; i++) {
//             pqMin.offer(nums[i]);
//             minSum += nums[i];
//         }
//         leftMins[oneThird-1] = minSum;

//         for (int i = oneThird; i < n-oneThird; i++) {
//             int x = nums[i];
//             if (x < pqMin.peek()) {
//                 minSum += x-pqMin.poll();
//                 pqMin.offer(x);
//             }

//             leftMins[i] = minSum;
//         }
        
//         for (int i = n-1; i >= n-oneThird; i--) {
//             pqMax.offer(nums[i]);
//             maxSum += nums[i];
//         }
//         rightMaxs[n-oneThird] = maxSum;

//         for (int i = n-oneThird-1; i >= oneThird-1; i--) {
//             int x = nums[i];
//             if (x > pqMax.peek()) {
//                 maxSum += x-pqMax.poll();
//                 pqMax.offer(x);
//             }

//             rightMaxs[i] = maxSum;
//         }

//         for (int i = oneThird-1; i < n-oneThird; i++) {
//             ret = Math.min(ret, leftMins[i]-rightMaxs[i+1]);
//         }

//         return ret;
//     }
// }