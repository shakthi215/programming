class countPrimeSetBits {
    public int countPrimeSetBits1(int L, int R) {
        int ans = 0;
        for (int x = L; x <= R; ++x)
            if (isSmallPrime(Integer.bitCount(x)))
                ans++;
        return ans;
    }
    public boolean isSmallPrime(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }
}





// class Solution {
//     public int countPrimeSetBits(int left, int right) {
//         int count=0;
        
//         for (int i=left;i<=right;i++) {
//             int setBits=Integer.bitCount(i);
//             if (isPrime(setBits)) {
//                 count++;
//             }
//         }
//         return count;
//     }
    
//     private boolean isPrime(int n) {
//         if (n<=1) {
//             return false;
//         }
//         for (int i=2;i*i <= n;i++) {
//             if (n%i==0) {
//                 return false;
//             }
//         }
        
//         return true;
//     }
// }