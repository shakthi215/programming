public class SqrtFloor {
    public static int sqrtFloor(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2, ans = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= x / mid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sqrtFloor(10)); // Output: 3
    }
}
