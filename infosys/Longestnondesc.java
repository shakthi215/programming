// You are using Java
import java.util.*;
public class Longestnondesc{
    public static int get_ans(int n,int m,int[] arr){
        int max=512;
        int[][] dp=new int[n][max];
        int ans=0;
        
        for(int i=0;i<n;i++){
            int x=arr[i];
            if(x<max){
                dp[i][x]=Math.max(dp[i][x],1);
                if(x>=m)ans=Math.max(ans,1);
            }
            for(int j=0;j<i;j++){
                if(arr[j]<=arr[i]){
                    for(int v=0;v<max;v++){
                        if(dp[j][v]==0)continue;
                        int nx=v^arr[i];
                        if(nx>=max)continue;
                        dp[i][nx]=Math.max(dp[i][nx],dp[j][v]+1);
                        if(nx>=m)ans=Math.max(ans,dp[i][nx]);
                    }
                }
            }
        }
        return ans;
        
        // int dp[]=new int[n];
        // int ans=1;
        // for(int i=0;i<n;i++){
        //     dp[i]=1;
        //     for(int j=0;j<i;j++){
        //         if(arr[j]<=arr[i]){
        //             dp[i]=Math.max(dp[i],dp[j]+1);
        //         }
        //     }
        //     ans=Math.max(ans,dp[i]);
        // }
        // return ans;
    }
    public static void main(String sdfsf[]){
        try (Scanner s = new Scanner(System.in)) {
            int n=s.nextInt();
            int arr[]=new int[n];
            int m=s.nextInt();
            for(int i=0;i<n;i++)arr[i]=s.nextInt();
            System.out.print(get_ans(n,m,arr));
        }
    }
}








// import java.util.*;
// import java.lang.*;

// class Solution {

//     public static int get_ans(int N, int M, int[] Parent, int[] Val, int Q, String[] queries) {
//         int totalMinCost = 0;

//         for (String query : queries) {
//             int maxNaturalPaths = -1;
//             int minCostForMaxPaths = -1;

//             // Iterate through all possible edge flip combinations.  Since at most one flip per
//             // node is allowed, the number of possible flips is bounded.

//             // Generate all possible combinations of edges to flip.  Represent each combination
//             // as a list of edge indices.
//             List<List<Integer>> allFlipCombinations = generateFlipCombinations(N, Parent);

//             for (List<Integer> flipCombination : allFlipCombinations) {
//                 // Create a copy of the Val array to simulate the flips.
//                 int[] currentVal = Arrays.copyOf(Val, N);

//                 // Apply the flips to the copied Val array.
//                 int currentCost = 0;
//                 for (int edgeIndex : flipCombination) {
//                     currentCost += M;

//                     int child = edgeIndex;
//                     int parent = Parent[edgeIndex];

//                     currentVal[child] = 1 - currentVal[child];
//                     currentVal[parent] = 1 - currentVal[parent];
//                 }

//                 // Calculate the number of natural root-to-leaf paths for this flip combination.
//                 int naturalPaths = countNaturalPaths(N, Parent, currentVal, query);


//                 // Update the maxNaturalPaths and minCostForMaxPaths if necessary.
//                 if (naturalPaths > maxNaturalPaths) {
//                     maxNaturalPaths = naturalPaths;
//                     minCostForMaxPaths = currentCost;
//                 } else if (naturalPaths == maxNaturalPaths) {
//                     if (minCostForMaxPaths == -1 || currentCost < minCostForMaxPaths) {
//                         minCostForMaxPaths = currentCost;
//                     }
//                 }
//             }

//             totalMinCost += minCostForMaxPaths;
//         }

//         return totalMinCost;
//     }

//     // Helper function to generate all valid flip combinations.
//     private static List<List<Integer>> generateFlipCombinations(int N, int[] Parent) {
//         List<List<Integer>> result = new ArrayList<>();
//         result.add(new ArrayList<>()); // Add the empty set (no flips).

//         // Iterate over all nodes (excluding the root, since root has no incoming edges).
//         for (int i = 1; i < N; i++) {
//             final int child = i;
//             List<List<Integer>> newCombinations = new ArrayList<>();

//             // For each existing combination, create a new combination by adding the current edge.
//             for (List<Integer> combination : result) {
//                 List<Integer> newCombination = new ArrayList<>(combination);

//                 //Check if a node has already been flipped
//                 boolean validFlip = true;
//                 for(int edgeIndex : newCombination){
//                    if(edgeIndex == child || Parent[edgeIndex] == child || edgeIndex == Parent[child]){
//                        validFlip = false;
//                        break;
//                    }
//                 }

//                 if(validFlip){
//                     newCombination.add(child);
//                     newCombinations.add(newCombination);
//                 }


//             }
//             result.addAll(newCombinations);
//         }

//         return result;
//     }

//     // Helper function to count the number of natural root-to-leaf paths.
//     private static int countNaturalPaths(int N, int[] Parent, int[] Val, String query) {
//         int count = 0;

//         // Iterate through all leaf nodes.
//         for (int i = 0; i < N; i++) {
//             //check if it is leaf node
//             boolean isLeaf = true;
//             for(int j=1; j<N; j++){
//                 if(Parent[j] == i){
//                     isLeaf = false;
//                     break;
//                 }
//             }

//             if (!isLeaf) continue;

//             // Build the path from the leaf to the root.
//             StringBuilder path = new StringBuilder();
//             int currentNode = i;

//             while (currentNode != 0) {
//                 path.insert(0, Val[currentNode]);
//                 currentNode = Parent[currentNode];
//             }
//             path.insert(0, Val[0]); // Add the root node value.

//             // Check if the query string is a substring of the path.
//             if (path.toString().contains(query)) {
//                 count++;
//             }
//         }

//         return count;
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         int N = scanner.nextInt();
//         int M = scanner.nextInt();

//         int[] Parent = new int[N];
//         for (int i = 0; i < N; i++) {
//             Parent[i] = scanner.nextInt();
//         }

//         int[] Val = new int[N];
//         for (int i = 0; i < N; i++) {
//             Val[i] = scanner.nextInt();
//         }

//         int Q = scanner.nextInt();
//         String[] queries = new String[Q];
//         for (int i = 0; i < Q; i++) {
//             queries[i] = scanner.next();
//         }

//         int result = get_ans(N, M, Parent, Val, Q, queries);
//         System.out.println(result);

//         scanner.close();
//     }
// }






// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// class Solution {
//     static class Node {
//         int data;
//         Node left, right;

//         Node(int data) {
//             this.data = data;
//             left = right = null;
//         }
//     }

//     public static List<Node> constructTrees(int start, int end) {
//         List<Node> list = new ArrayList<>();

//         if (start > end) {
//             list.add(null);
//             return list;
//         }

//         for (int i = start; i <= end; i++) {
//             List<Node> leftSubtrees = constructTrees(start, i - 1);
//             List<Node> rightSubtrees = constructTrees(i + 1, end);

//             for (Node left : leftSubtrees) {
//                 for (Node right : rightSubtrees) {
//                     Node node = new Node(i);
//                     node.left = left;
//                     node.right = right;
//                     list.add(node);
//                 }
//             }
//         }
//         return list;
//     }

//     public static void preorderTraversal(Node node) {
//         if (node != null) {
//             System.out.print(node.data + " ");
//             preorderTraversal(node.left);
//             preorderTraversal(node.right);
//         }
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int n = scanner.nextInt();
//         scanner.close();

//         List<Node> trees = constructTrees(1, n);

//         for (Node tree : trees) {
//             preorderTraversal(tree);
//             System.out.println();
//         }
//     }
// }




// public class KnightProbability {

//     public static void main(String[] args) {
//         int k = Integer.parseInt(System.console().readLine());
//         double probability = knightProbability(8, k, 0, 0);
//         System.out.printf("%.4f%n", probability);
//     }

//     public static double knightProbability(int n, int k, int row, int column) {
//         double[][][] dp = new double[k + 1][n][n];
//         int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

//         // Base case: probability of staying at the initial position after 0 steps is 1.
//         dp[0][row][column] = 1.0;

//         // Iterate through the number of steps from 1 to k.
//         for (int step = 1; step <= k; step++) {
//             // Iterate through all the cells on the board.
//             for (int i = 0; i < n; i++) {
//                 for (int j = 0; j < n; j++) {
//                     // Iterate through all possible knight moves.
//                     for (int[] move : moves) {
//                         int prevRow = i - move[0];
//                         int prevCol = j - move[1];

//                         // Check if the previous position is within the board.
//                         if (prevRow >= 0 && prevRow < n && prevCol >= 0 && prevCol < n) {
//                             // Add the probability of reaching the current cell from the previous cell.
//                             dp[step][i][j] += dp[step - 1][prevRow][prevCol] / 8.0;
//                         }
//                     }
//                 }
//             }
//         }

//         // Calculate the total probability of the knight staying on the board after k steps.
//         double totalProbability = 0.0;
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 totalProbability += dp[k][i][j];
//             }
//         }

//         return totalProbability;
//     }
// }





// import java.util.*;
// import java.lang.*;

// class Solution {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int t = scanner.nextInt();
//         while (t-- > 0) {
//             int n = scanner.nextInt();
//             int e = scanner.nextInt();
//             ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//             for (int i = 0; i < n; i++) {
//                 adj.add(new ArrayList<>());
//             }
//             for (int i = 0; i < e; i++) {
//                 int u = scanner.nextInt();
//                 int v = scanner.nextInt();
//                 adj.get(u).add(v);
//                 adj.get(v).add(u);
//             }
//             boolean[] visited = new boolean[n];
//             ArrayList<Integer> dfsTraversal = new ArrayList<>();
//             dfs(0, adj, visited, dfsTraversal);
//             for (int node : dfsTraversal) {
//                 System.out.print(node + " ");
//             }
//             System.out.println();
//         }
//         scanner.close();
//     }

//     private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfsTraversal) {
//         visited[node] = true;
//         dfsTraversal.add(node);
//         for (int neighbor : adj.get(node)) {
//             if (!visited[neighbor]) {
//                 dfs(neighbor, adj, visited, dfsTraversal);
//             }
//         }
//     }
// }


