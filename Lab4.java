public class Lab4{
    public class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {

            this.val = val;

            this.left = left;

            this.right = right;

        }

    }

 public static TreeNode invertTree(TreeNode root){
    if (root == null){
      return null;
    }

    else{
      
        
        TreeNode leftSubTreeNode = invertTree(root.left);
        TreeNode RightSubTreeNode = invertTree(root.right);
        root.left = RightSubTreeNode;
        root.right = leftSubTreeNode;
        return root;
    }
}

 private static void printTree(TreeNode root) {
    if (root != null) {
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}

      public static void main(String args[]){  
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("tree before transformation: ");
        printTree(root);
        System.out.println();

        TreeNode invertedTree = invertTree(root);
        System.out.println("tree after the inversion");
        printTree(invertedTree);
        System.out.println();


      }
}
 
