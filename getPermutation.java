// 60. Permutation Sequence
// Attempted
// Hard
// Topics
// premium lock icon
// Companies
// The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

 

// Example 1:

// Input: n = 3, k = 3
// Output: "213"
// Example 2:

// Input: n = 4, k = 9
// Output: "2314"
// Example 3:

// Input: n = 3, k = 1
// Output: "123"
 


import java.util.*;
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;

        // Step 1: Prepare numbers list and compute n!
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            fact *= i;
        }

        k--; // Convert k to 0-based index
        StringBuilder result = new StringBuilder();

        // Step 2: Compute each digit of the result
        for (int i = 0; i < n; i++) {
            fact = fact / (n - i); // (n - i - 1)!
            int index = k / fact;  // Select index from the list
            result.append(numbers.get(index));
            numbers.remove(index); // Remove used number
            k = k % fact; // Update k for next position
        }

        return result.toString();
    }
}