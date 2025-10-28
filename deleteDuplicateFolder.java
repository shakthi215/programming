// Example 1:


// Input: paths = [["a"],["c"],["d"],["a","b"],["c","b"],["d","a"]]
// Output: [["d"],["d","a"]]
// Explanation: The file structure is as shown.
// Folders "/a" and "/c" (and their subfolders) are marked for deletion because they both contain an empty
// folder named "b".
// Example 2:


// Input: paths = [["a"],["c"],["a","b"],["c","b"],["a","b","x"],["a","b","x","y"],["w"],["w","y"]]
// Output: [["c"],["c","b"],["a"],["a","b"]]
// Explanation: The file structure is as shown. 
// Folders "/a/b/x" and "/w" (and their subfolders) are marked for deletion because they both contain an empty folder named "y".
// Note that folders "/a" and "/c" are identical after the deletion, but they are not deleted because they were not marked beforehand.
// Example 3:


// Input: paths = [["a","b"],["c","d"],["c"],["a"]]
// Output: [["c"],["c","d"],["a"],["a","b"]]
// Explanation: All folders are unique in the file system.
// Note that the returned array can be in a different order as the order does not matter.


import java.util.*;
class Solution {
    static class Node {
        Map<String, Node> children = new TreeMap<>();
        boolean deleted = false;
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root = new Node();

        for (List<String> path : paths) {
            Node curr = root;
            for (String name : path) {
                curr = curr.children.computeIfAbsent(name, k -> new Node());
            }
        }

        Map<String, List<Node>> map = new HashMap<>();
        encode(root, map);

        for (List<Node> group : map.values()) {
            if (group.size() > 1) {
                for (Node n : group) {
                    n.deleted = true;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        collect(root, new ArrayList<>(), result);
        return result;
    }

    private String encode(Node node, Map<String, List<Node>> map) {
        if (node.children.isEmpty()) return "()";

        List<String> parts = new ArrayList<>();
        for (Map.Entry<String, Node> entry : node.children.entrySet()) {
            String sub = encode(entry.getValue(), map);
            parts.add(entry.getKey() + sub);
        }
        Collections.sort(parts);
        String sign = "(" + String.join("", parts) + ")";
        map.computeIfAbsent(sign, k -> new ArrayList<>()).add(node);
        return sign;
    }

    private void collect(Node node, List<String> path, List<List<String>> res) {
        for (Map.Entry<String, Node> entry : node.children.entrySet()) {
            if (entry.getValue().deleted) continue;
            path.add(entry.getKey());
            res.add(new ArrayList<>(path));
            collect(entry.getValue(), path, res);
            path.remove(path.size() - 1);
        }
    }
}