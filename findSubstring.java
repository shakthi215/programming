// Example 1:

// Input: s = "barfoothefoobarman", words = ["foo","bar"]

// Output: [0,9]

// Explanation:

// The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
// The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

// Example 2:

// Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

// Output: []

// Explanation:

// There is no concatenated substring.

// Example 3:

// Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

// Output: [6,9,12]

// Explanation:

// The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
// The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
// The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].



import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        if (words.length == 0 || s.length() == 0) {
            return ans;
        }

        int wordSize = words[0].length();
        int wordCount = words.length;
        int N = s.length();

        HashMap<String,Integer> originalCount = new HashMap<>();
        for(int i = 0; i<words.length; i++){
            originalCount.put(words[i], originalCount.getOrDefault(words[i],0)+1);
        }

        for(int offset = 0; offset<wordSize; offset++){
            HashMap<String,Integer> currentCount = new HashMap<>();
            int start = offset;
            int count = 0;
            for(int end = offset; end + wordSize <= N; end += wordSize){
                String currWord = s.substring(end, end + wordSize);
                if(originalCount.containsKey(currWord)){
                    currentCount.put(currWord, currentCount.getOrDefault(currWord,0)+1);
                    count++;

                    while(currentCount.get(currWord)>originalCount.get(currWord)){
                        String startWord = s.substring(start,start+wordSize);
                        currentCount.put(startWord, currentCount.get(startWord)-1);
                        start+=wordSize;
                        count--;                        
                    }

                    if(count == wordCount){
                        ans.add(start);
                    }
                    
                }
                else{
                    count = 0;
                    start = end + wordSize;
                    currentCount.clear();
                }
            }

        }
        return ans;
    }
}