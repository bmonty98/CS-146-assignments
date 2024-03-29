
class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):

        self.val = val

        self.left = left

        self.right = right
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

            return LCA_helper(root,p,q)

     


     
def LCA_helper( root, p, q):
    if not root:
        return None

    elif root.val == p.val or root.val == q.val:
        return root

    leftSubTree = LCA_helper(root.left, p, q)
    rightSubTree = LCA_helper(root.right, p, q)

    if leftSubTree and rightSubTree:
        return root

    elif not leftSubTree:
        return rightSubTree

    elif not rightSubTree:
        return leftSubTree

    return None
     
     
        
def printNode(root):
     if root is not None:
        print(root.val)

if __name__ == "__main__":
    p = TreeNode(3)
    q = TreeNode(1)
    r = TreeNode(5)

    root = TreeNode(4)
    root.left =  TreeNode(3)
    root.right =  TreeNode(8)
    root.left.left =  TreeNode(1)
    root.right.left =  TreeNode(5)
    root.right.right =  TreeNode(9)
    thy_node = root.lowestCommonAncestor(root, p, q)
    thy_node2 = root.lowestCommonAncestor(root, q, r)

    print(f"here is the expected LCA of {p.val}  and {q.val}: ")
    printNode(thy_node)
    print("\n")
    print(f"here is the expected LCA of {q.val} and {r.val}: ")
    printNode(thy_node2)
