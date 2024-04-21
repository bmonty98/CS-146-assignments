 here we got our khans algortithm where we have:
    
    Took a khans algorithm approach to solving this problem. We start by creating an adjacency list and the indegree count list and give those as well as my toal amount of unique nodes to the helper KhansAlgorithm method. that method then
    goes and does the Khans algorithm approach, we take our nodes that are indicated to have no indegress and add them to the queue. we then go through our adjacency list and constantly pop and add the remaining nodes and decrement their indegrees. I kinda did over kill for this because this assignment only wanted really for me to code if graphs are basically DAGS or not but I wrote a majority of the code and realized this so I didnt add the final part of the khans algorithm where I would then add the sorted nodes into an array where they would be sorted using the topological sort. But on the good sidem will be able to  easily add to this so that I can return the sorted list if I want to in the future!
    
    """
