import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    // Function to generate all possible palindrome partitions
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        backtrack(s, 0, currentPartition, result);
        return result;
    }

    // Backtracking helper function
    private static void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        // If we've reached the end of the string, add the current partition to the result
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        // Try to partition the string into palindromes starting from 'start'
        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            if (isPalindrome(substring)) {
                // If the substring is a palindrome, add it to the current partition
                currentPartition.add(substring);
                // Recursively partition the remaining string
                backtrack(s, i + 1, currentPartition, result);
                // Backtrack: remove the last added substring
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    // Helper function to check if a string is a palindrome
    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "aab";
        System.out.println("Palindrome partitions for 'aab': " + partition(s1));

        String s2 = "a";
        System.out.println("Palindrome partitions for 'a': " + partition(s2));
    }
}





// public class PalindromicPartitioning {

//     // Function to find the minimum number of cuts for palindromic partitioning
//     public static int minCut(String s) {
//         int n = s.length();
        
//         // Step 1: Create a palindrome table
//         boolean[][] palindrome = new boolean[n][n];
        
//         // All substrings of length 1 are palindromes
//         for (int i = 0; i < n; i++) {
//             palindrome[i][i] = true;
//         }
        
//         // Check for substrings of length 2
//         for (int i = 0; i < n - 1; i++) {
//             if (s.charAt(i) == s.charAt(i + 1)) {
//                 palindrome[i][i + 1] = true;
//             }
//         }
        
//         // Check for substrings of length greater than 2
//         for (int len = 3; len <= n; len++) {
//             for (int i = 0; i <= n - len; i++) {
//                 int j = i + len - 1;
//                 if (s.charAt(i) == s.charAt(j) && palindrome[i + 1][j - 1]) {
//                     palindrome[i][j] = true;
//                 }
//             }
//         }
        
//         // Step 2: Create the dp array to store minimum cuts
//         int[] dp = new int[n];
        
//         // Initialize dp array
//         for (int i = 0; i < n; i++) {
//             if (palindrome[0][i]) {
//                 dp[i] = 0; // No cuts needed if the substring s[0...i] is a palindrome
//             } else {
//                 dp[i] = Integer.MAX_VALUE;
//             }
//         }
        
//         // Step 3: Calculate the minimum cuts for each substring
//         for (int i = 1; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (palindrome[j + 1][i]) {
//                     dp[i] = Math.min(dp[i], dp[j] + 1);
//                 }
//             }
//         }
        
//         // The result is the minimum cuts for the entire string s[0...n-1]
//         return dp[n - 1];
//     }

//     public static void main(String[] args) {
//         String s = "aab";
//         System.out.println("Minimum cuts needed for palindromic partitioning: " + minCut(s));
//     }
// }
