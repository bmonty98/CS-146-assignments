public class HW9 {

    
    public static TreeNode LCA_Helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        else if(root.val == q.val || root.val == p.val){
            return root;

        }

            TreeNode leftSubTree = LCA_Helper(root.left, p, q);
            TreeNode RightSubTree = LCA_Helper(root.right, p, q);


        if(leftSubTree !=null && RightSubTree != null){

            return root;
        }
        else if( leftSubTree == null){
            return RightSubTree;
        }

        else if(RightSubTree == null){
            return leftSubTree;
        }

        return null;
        
    }

    
    
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        

        return LCA_Helper(root, p, q); 
     }

     
     

     public void printNode(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = lowestCommonAncestor(root, p, q);
        if (lca != null) {
            System.out.println("The LCA of " + p.val + " and " + q.val + " is: " + lca.val);
        } else {
            System.out.println("No LCA found for " + p.val + " and " + q.val);
        }
    }

     
     
     
     

     public static void main(String args[]){  
        HW9 hw9 = new HW9(); // god I hate java sometimes so much such a pointless operation of creating a class variable of a useless class just so i can have no errors god help me ima pop a blood vessel took me an hour to figure out the issue grrr.
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        TreeNode r = new TreeNode(5);

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        hw9.printNode(root,p,q);
        hw9.printNode(root,p,r);
    }
}
