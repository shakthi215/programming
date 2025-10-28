// A word is considered valid if:

// It contains a minimum of 3 characters.
// It contains only digits (0-9), and English letters (uppercase and lowercase).
// It includes at least one vowel.
// It includes at least one consonant.
// You are given a string word.

// Return true if word is valid, otherwise, return false.

// Notes:

// 'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
// A consonant is an English letter that is not a vowel.
 

// Example 1:

// Input: word = "234Adas"

// Output: true

// Explanation:

// This word satisfies the conditions.

// Example 2:

// Input: word = "b3"

// Output: false

// Explanation:

// The length of this word is fewer than 3, and does not have a vowel.

// Example 3:

// Input: word = "a3$e"

// Output: false

// Explanation:

// This word contains a '$' character and does not have a consonant.




class Solution {
    public boolean isValid(String word) {
        char[] arr=word.toCharArray();
        if(arr.length<3)return false;
        int d=0,c=0,v=0;
        for(int i:arr){
            if(Character.isDigit(i)){
                d++;
            }else if(Character.isAlphabetic(i)){
                if(i=='a'||i=='e'||i=='i'||i=='o'||i=='u'||i=='A'||i=='E'||i=='I'||i=='O'||i=='U'){
                    v++;
                }else{
                    c++;
                }
            }else{
                return false;
            }
        }
        if(v<1||c<1)return false;
        return true;
    }
}




// class Solution {
//     public boolean isValid(String word) {
//         if(word.length() < 3) {
//             return false;
//         }

//         boolean hasVowel = false;
//         boolean hasConsonant = false;

//         for(int i = 0; i < word.length(); i++) {
//             switch(word.charAt(i)) {
//                 case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U':
//                     hasVowel = true;
//                     break;
//                 case 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z',
//                      'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z':
//                     hasConsonant = true;
//                     break;
//                 case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
//                     break;
//                 default:
//                     return false;
//             }
//         }

//         return hasVowel && hasConsonant;
//     }
// }