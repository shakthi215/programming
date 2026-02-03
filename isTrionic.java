class isTrionic {

    public boolean isTrionic1(int[] nums) {
        int n = nums.length;
        int i = 1;
        while (i < n && nums[i - 1] < nums[i]) {
            i++;
        }
        int p = i - 1;
        while (i < n && nums[i - 1] > nums[i]) {
            i++;
        }
        int q = i - 1;
        while (i < n && nums[i - 1] < nums[i]) {
            i++;
        }
        int flag = i - 1;
        return (p != 0) && (q != p) && (flag == n - 1 && flag != q);
    }
}



// class Solution {

//     public boolean isTrionic(int[] nums) {
//         int n = nums.length;
//         if (nums[0] >= nums[1]) {
//             return false;
//         }
//         int count = 1;
//         for (int i = 2; i < n; i++) {
//             if (nums[i - 1] == nums[i]) {
//                 return false;
//             }
//             if ((nums[i - 2] - nums[i - 1]) * (nums[i - 1] - nums[i]) < 0) {
//                 count++;
//             }
//         }
//         return count == 3;
//     }
// }