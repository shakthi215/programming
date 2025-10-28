// Example 1:

// Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
// Output: ["/a","/c/d","/c/f"]
// Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
// Example 2:

// Input: folder = ["/a","/a/b/c","/a/b/d"]
// Output: ["/a"]
// Explanation: Folders "/a/b/c" and "/a/b/d" will be removed because they are subfolders of "/a".
// Example 3:

// Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
// Output: ["/a/b/c","/a/b/ca","/a/b/d"]

import java.util.*;
class Solution {

    public List<String> removeSubfolders(String[] folder) {
        // Sort the folders alphabetically
        Arrays.sort(folder);

        // Initialize the result list and add the first folder
        List<String> result = new ArrayList<>();
        result.add(folder[0]);

        // Iterate through each folder and check if it's a sub-folder of the last added folder in the result
        for (int i = 1; i < folder.length; i++) {
            String lastFolder = result.get(result.size() - 1);
            lastFolder += '/';

            // Check if the current folder starts with the last added folder path
            if (!folder[i].startsWith(lastFolder)) {
                result.add(folder[i]);
            }
        }

        // Return the result containing only non-sub-folders
        return result;
    }
}