class hasAlternatingBits {
    public boolean hasAlternatingBits1(int n) {
        int cur = n % 2;
        n /= 2;
        while (n > 0) {
            if (cur == n % 2) return false;
            cur = n % 2;
            n /= 2;
        }
        return true;
    }
}









// class Solution {
//     public boolean hasAlternatingBits(int n) {
//         String str=Integer.toBinaryString(n);
//         for(char c=0;c<str.length()-1;c++){
//             if(str.charAt(c)==str.charAt(c+1))return false;
//         }
//         return true;
//     }
// }