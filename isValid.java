// Example 1:

// Input: s = "()"

// Output: true

// Example 2:

// Input: s = "()[]{}"

// Output: true

// Example 3:

// Input: s = "(]"

// Output: false

// Example 4:

// Input: s = "([])"

// Output: true

import java.util.*;
class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) { 
            if (c == '(')
                stack.push(')'); 
            else if (c == '{') 
                stack.push('}');
            else if (c == '[') 
                stack.push(']'); 
            else if (stack.isEmpty() || stack.pop() != c) 
                return false;
        }
        return stack.isEmpty();
    }
}