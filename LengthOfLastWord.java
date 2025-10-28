public class LengthOfLastWord {

    static class Solution {
        public int lengthOfLastWord(String s) {
            s = s.trim();

            int length = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != ' ') {
                    length++;
                } else if (length > 0) {
                    break;
                }
            }

            return length;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String input = "   fly me   to   the moon  ";
        int result = sol.lengthOfLastWord(input);

        System.out.println("Length of last word: " + result);  // Output: 4
    }
}
