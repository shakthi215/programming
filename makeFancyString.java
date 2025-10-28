// Example 1:

// Input: s = "leeetcode"
// Output: "leetcode"
// Explanation:
// Remove an 'e' from the first group of 'e's to create "leetcode".
// No three consecutive characters are equal, so return "leetcode".
// Example 2:

// Input: s = "aaabaaaa"
// Output: "aabaa"
// Explanation:
// Remove an 'a' from the first group of 'a's to create "aabaaaa".
// Remove two 'a's from the second group of 'a's to create "aabaa".
// No three consecutive characters are equal, so return "aabaa".
// Example 3:

// Input: s = "aab"
// Output: "aab"
// Explanation: No three consecutive characters are equal, so return "aab".




class Solution {
    public String makeFancyString(String s) {
        char prev = s.charAt(0);
        int frequency = 1;
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                frequency++;
            } else {
                prev = s.charAt(i);
                frequency = 1;
            }
            if (frequency < 3) ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}