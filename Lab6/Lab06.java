import java.util.*;

class Lab06 {
    /**
     * Here is the notion of the problem:
     *
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites
     * where prerequisites[i] = [ai, bi] indicates that you must take course [bi] first if you want to take course ai.
     *
     * Examples:
     *
     * Test Case 1:
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     *
     * Test Case 2:
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0,
     * and to take course 0 you should also have finished course 1. So it is impossible.
     */

    /**
     * Here we got our Kahn's algorithm where we have:
     *
     * @param adjacencyA     made from the 2D list of the prerequisites nodes
     * @param totalNodes     is the total amount of nodes received from the number of courses (nodes)
     * @param indegreeCounter is a list connecting the value of the # of indegrees in the corresponding classes
     * @return true or false: -> if all classes can be taken in the right order then true, if not (not a DAG) return false
     */
    private boolean khansAlgorithm(List<List<Integer>> adjacencyA, int totalNodes, int[] indegreeCounter) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < totalNodes; i++) {
            if (indegreeCounter[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.remove();

            for (int val : adjacencyA.get(current)) {
                indegreeCounter[val]--;
                if (indegreeCounter[val] == 0) {
                    queue.add(val);
                }
            }

            count++;
        }

        // Catches if the count of nodes is off from the total nodes. If this condition is true, it can indicate that the given graph is not a DAG.
        if(count != totalNodes){
            return false;
        }
        return true;
    }

    /**
     * Here is the method canFinish which uses a helper method called KhansAlgorithm to perform the indicated algorithm on the given adjacency list and indegree count, as well as total nodes given to it.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // List of Lists to create an empty 2D array of length number of unique nodes in the graph, which will be used in the helper method as our adjacency list representation
        List<List<Integer>> adjArray = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjArray.add(new ArrayList<>());
        }

        // Creates an empty array of length (# of unique nodes) which will be used to keep track of the indegree for the integer value of the node, i.e., index 0 will be how many indegrees point to zero, then 1, etc.
        int[] indegreeCounter = new int[numCourses];

        // for each loop that allows me to find the adjacentcies from prequisites and add their frequency to indegreeCounter (should have done this in my python code would have made it easier)
        for (int[] prereq : prerequisites) {
            adjArray.get(prereq[1]).add(prereq[0]);
            indegreeCounter[prereq[0]]++;
        }

        return khansAlgorithm(adjArray, numCourses, indegreeCounter);
    }

    public static void main(String[] args) {
        Lab06 lab06 = new Lab06();
        int courses = 2;
        int[][] preReqs = {{1, 0}};
        int[][] preReqs2 = {{1, 0}, {0, 1}};

        System.out.println(lab06.canFinish(courses, preReqs));
        System.out.println(lab06.canFinish(courses, preReqs2));
    }
}
