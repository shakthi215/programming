import java.util.*;
class minRemoval {

    public int minRemoval1(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int ans = n;
        int right = 0;

        for (int left = 0; left < n; left++) {
            while (right < n && nums[right] <= (long) nums[left] * k) {
                right++;
            }
            ans = Math.min(ans, n - (right - left));
        }

        return ans;
    }
}