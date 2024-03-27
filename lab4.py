
class TreeNode(object):

      
     """
     here is the algorithm for how we will do this via python

     base case, check to see if the root is null

    then the first thing we do is swap the first left and right children
    of the node, dont need to traverse to ANY PART OF THE TREE
    UST START OF THE ROOT

    once we get here start the swapping

    use temp, store value
    in temp then switch the values around

    BUT WE DONT HAVE THE CHILDREN

    so we will need to have to flip its following values, doing this via pointers

    but you dont have to worry because the pointers are still connected to it

    then we do recursion for the left and right children of the root
    """


     def __init__(self, val=0, left=None, right=None):

          self.val = val

          self.left = left

          self.right = right
    




     # checks to see if we get to the null children and if we do we return root as the basecase.
     # if not the we end up doing recursive calls on the left and right children of the root node and do the swapping.
     def invertTree(self, root):
     
          if root == None:
               return root
          else:
               temp = root.left
               root.left = root.right
               root.right= temp
               self.invertTree(root.left)
               self.invertTree(root.right)
"--------------------- end of tree class -------------------------------------"

# Simple class used for printing the tree out to command line.
def printTree(root):
    if root is not None:
        print(root.val)
        printTree(root.left)
        printTree(root.right)


# main to test InvertTree Method
if __name__ == "__main__":
     root = TreeNode(1)
     root.left = TreeNode(2)
     root.right = TreeNode(8)
     root.left.left = TreeNode(3)
     root.left.right = TreeNode(4)
     root.right.left = TreeNode(5)
     root.right.right = TreeNode(6)

    # Print the original tree
     print("Original Tree: ")
     printTree(root)

    # Invert the tree
     root.invertTree(root)

    # Print the inverted tree
     print("\n\nInverted Tree:")
     printTree(root)


     
     
