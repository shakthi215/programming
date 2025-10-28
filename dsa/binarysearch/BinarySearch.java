public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};  // Sorted!
        int target = 7;
        int result = binarySearch(nums, target);
        System.out.println(result >= 0 ? "Found at index " + result : "Not found");
    }
}










// int left=0;
// int right=arr.length-1;
// while(left<=right){
//     int mid=left+(right-left)/2;
//     if(arr[mid]==target)return mid;
//     else if(arr[mid]<target)left=mid+1;
//     else if(arr[mid]>target)right=mid-1;
// }