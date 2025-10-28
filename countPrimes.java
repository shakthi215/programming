// Example 1:

// Input: n = 10
// Output: 4
// Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
// Example 2:

// Input: n = 0
// Output: 0
// Example 3:

// Input: n = 1
// Output: 0



// class Solution {
//     public int countPrimes(int n) {
//         boolean[] seen = new boolean[n];
//         int ans = 0;
//         for (int num = 2; num < n; num++) {
//             if (seen[num]) continue;
//             ans += 1;
//             for (long mult = (long)num * num; mult < n; mult += num)
//                 seen[(int)mult] = true;
//         }
//         return ans;
//     }
// }


class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        
        boolean[] isPrime = new boolean[n]; // Create a boolean array to track prime numbers.
        for (int i = 2; i < n; i++) {
            isPrime[i] = true; // Assume all numbers are prime initially.
        }
        
        // Implement the sieve: mark non-prime numbers.
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) { // If i is prime, mark all its multiples as non-prime.
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Count the primes.
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        
        return count;
    }
}