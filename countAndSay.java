// Example 1:

// Input: n = 4

// Output: "1211"

// Explanation:

// countAndSay(1) = "1"
// countAndSay(2) = RLE of "1" = "11"
// countAndSay(3) = RLE of "11" = "21"
// countAndSay(4) = RLE of "21" = "1211"
// Example 2:

// Input: n = 1

// Output: "1"

// Explanation:

// This is the base case.



class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == res.charAt(j - 1)) {
                    count++;
                } else {
                    temp.append(count).append(res.charAt(j - 1));
                    count = 1;
                }
            }
            temp.append(count).append(res.charAt(res.length() - 1));
            res = temp.toString();
        }
        return res;
    }
}