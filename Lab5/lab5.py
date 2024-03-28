class TreeNode(object):
    """ when going through the problem, we get a lower bound from the original root and make sure that all values to the right are larger, and that all values in left subtree are greater than 4
    then you return false, if that occurs then at the end we return false two values, min and max, update them at every step of the recursion and make sure that every value must keep these min and max happy for that current node we are on. SO, first we need to understand how to traverse the tree then we go and check this inequality and return true or false depending on this
    good answers will only have 5 - 6 lines of code.
    """


    def __init__(self, val=0, left=None, right=None):

            self.val = val

            self.left = left

            self.right = right

    

    def isValidBST(self, root):
            
        #validity checker is a method that is a helper for isValidBST as it goes through and recursively calls using a checking of min and max of current nodes to keep track if the 
        # child nodes are less than current node to the left and that the children nodes to the right are greater than the current node and then checs the continuous children till it passes or fails.
        def validityChecker(currentNode,min, max, ):
            if currentNode == None:
                return True
            elif currentNode.val <= min or currentNode.val >= max:
                return False
            else:
                 return validityChecker(currentNode.left, min, currentNode.val) and validityChecker(currentNode.right, currentNode.val, max)
            
        #base start call that defines min and max as positive and negative infinity on opposite spectrums as to not run into issues with edges cases with largest and smallest possible values.
        return validityChecker(root, float('-inf'),float('inf')) 
            
    # Simple class used for printing the tree out to command line.
def printTree(root):
    if root is not None:
        print(root.val)
        printTree(root.left)
        printTree(root.right)


# main to test isValidBST()
if __name__ == "__main__":
     root = TreeNode(4)
     root.left = TreeNode(3)
     root.right = TreeNode(8)
     root.left.left = TreeNode(1)
     root.right.left = TreeNode(5)
     root.right.right = TreeNode(9)

     root2 = TreeNode(1)
     root2.left = TreeNode(2)
     root2.right = TreeNode(8)
     root2.left.left = TreeNode(3)
     root2.left.right = TreeNode(4)
     root2.right.left = TreeNode(5)
     root2.right.right = TreeNode(6)
     print("Here is the outcome of case1 in the isValidBST() we expect true, we get...:  ")
     print(f"{root.isValidBST(root)}")
     print("Here is the outcome of case2 in the isValidBST() we expect False, we get...:  ")
     print(f"{root2.isValidBST(root2)}")
