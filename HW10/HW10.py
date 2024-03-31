from typing import Optional

class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):

        self.val = val

        self.left = left

        self.right = right

def levelOrder(self, root: Optional[TreeNode]) -> list[list[int]]:
    """ basically this is the tech,
    
    Step 1: we need to take each level and load them into the queue,
    Step2: check to see if the queue is empty in some sort of loop and then once it is, move to the next level
    step3: some sort of recursion im assuming that will move us to the next level
    
    """
    
    
    BFS_representation = []
    thy_queue = []


    if root is None:
        return None
    
    thy_queue.append(root)

    while(thy_queue):
        subList = []
        for i in range(len(thy_queue)):
            currentNode = thy_queue.pop(0)
            if currentNode:
                subList.append(currentNode.val)
                if currentNode.left:
                    thy_queue.append(currentNode.left)
                if currentNode.right:
                    thy_queue.append(currentNode.right)
                    
        if len(subList):
            BFS_representation.append(subList)

    return BFS_representation


def BFSPrinter(some_list: Optional[list[list[int]]]):
    if some_list is None:
        print("we are printing out NONE as we either got None or a root with no value!")
   
    else:
        
        print(some_list)
    


    
if __name__ == "__main__":

    
    root = TreeNode(4)
    root.left = TreeNode(3)
    root.right = TreeNode(8)
    root.left.left = TreeNode(1)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(9)

    root2 = TreeNode(17)
    root2.left = TreeNode(7)
    root3 = TreeNode(69)

    solution = levelOrder(None,root)
    BFSPrinter(solution)
    solution2 = levelOrder(None, None)
    BFSPrinter(solution2)
    solution = levelOrder(None,root2)
    BFSPrinter(solution)
    solution = levelOrder(None,root3)
    BFSPrinter(solution)