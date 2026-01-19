// 207. Course Schedule
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

 

// Example 1:

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.
// Example 2:

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 




import java.util.*;
public class CourseSchedule{
    public boolean canFinish(int numCourses, int[][] prerequisites){
        //Step 1: Build graph and indegree Array
        // Adjacency matrix or Adjaceny list
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        // Build the graph and indegree
        // Input: numCourses  = 4 prerequisites = [[1,0],[2,1],[3,2]]
        // dest = 1
        // src = 0
        for(int[] pair:prerequisites){
            int dest = pair[0];
            int src = pair[1];
            graph.get(src).add(dest);
            indegree[dest]++;
        }

        // prerequisites = [[1,0],[2,1],[3,2]]
        // This means To take course 1 you must complete 0 first
        // To take course 2 you must complete 1
        // To take course 3 you must complete 2
        // indegree[1]++ -> indegree[1] = 1
        // indegree[2]++ -> indegree[2] = 1
        // indegree[3]++ -> indegree[3] = 1
        // final indegree [0,1,1,1]
        // Course 0 has no prerequisites -> can be taken first
        // Course 1 -> needs course 0 be completed
        // Course 2 -> needs course 1 be completed
        // Course 3 -> needs course 2 be completed

        // Step 2: Enqueue courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0)
            queue.offer(i); // offer method does not throw any exception if the element cannot be added it will return false
        }

        int completedCourses = 0;

        // Step 3: BFS to take courses
        while (!queue.isEmpty()) {
            int course = queue.poll(); // 0
            completedCourses++;
            for(int neighbor:graph.get(course)) // find the neighbors
            {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0)
                     queue.offer(neighbor);

            }

        }
        return completedCourses == numCourses;
    }
}