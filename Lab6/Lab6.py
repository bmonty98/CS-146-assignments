class Lab06:  
   
   
    """
    Here is the notion of the problem:

    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites 
    where prerequisites[i] = [ai, bi] indicates that you must take course [bi] first if you want to take course ai.
        
        
        Examples:
        
    Test Case 1:

    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: true
    Explanation: There are a total of 2 courses to take. 
    To take course 1 you should have finished course 0. So it is possible.

    Test Case 2:

    Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take. 
    To take course 1 you should have finished course 0, 
    and to take course 0 you should also have finished course 1. So it is impossible.
    """

    """
    here we got our khans algortithm where we have:
    
    @param adjacencyA made from the 2D list of the prerequisites nodes
    
    @param totalNodes is the total abount of nodes recieved from the number of courses (nodes)
    
    @param indegreecounter is a list connecting the value of the # of indegrees in the corresponding classes
    
    return true or false: -> if all classes can be taken in right order then true, if not ( not a DAG) return false
    
    """

def khansAlgorithm(adjacencyA: list[list[int]], totalNodes: int, indegreeCounter: list[int]) -> bool:
    queue = []
    count = 0
    for i in range(totalNodes):
        if indegreeCounter[i] == 0:
            queue.append(i)
    
    count = 0
    while(queue):
        current = queue.pop(0)
        
        for val in adjacencyA[current]:
            indegreeCounter[val] -= 1
            if not indegreeCounter[val]:
                queue.append(val)
    
        count += 1
    #catches if the count of nodes is off from the total nodes. if this if condition is true it can indicate that the given graph is not a DAG.
    if count != totalNodes:
        return False
    return True
            
            
    
    
    
    
    

    """
    Here is method canFinish which uses a helper method called KhansAlgorithm to perform indicated algorithm on the given ajacency list and indegree count, as well as total nodes given to it.
    """

def canFinish(numCourses: int , prerequisites: list[list[int]]) -> bool:
    nodeLength = len(prerequisites)
    
    # List comprehension used to create an empty 2D array of length number of unique nodes in graph which will be used in helper method as our adjacency list representation
    adjArray = [[] for _ in range(numCourses)]
    # creates an empty list of length (# of unique nodes) which will be used to keep track of the indegree for the integer value of node ie index o will be how many indegrees point to zero, then 1, etc
    indegreeCounter = [0] * numCourses
    for i in range(nodeLength):
        adjArray[prerequisites[i][1]].append(prerequisites[i][0])
        indegreeCounter[prerequisites[i][0]] += 1
    return khansAlgorithm(adjArray,numCourses,indegreeCounter)



if __name__ == "__main__":
    courses = 2
    preReqs = [[1,0]]
    preReqs2 = [[1,0], [0,1]]
    print(canFinish(courses, preReqs))
    print(canFinish(courses, preReqs2))
    
    