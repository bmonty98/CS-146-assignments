
public class Lab5{



   

        public static boolean validityChecker(TreeNode currentNode, int min, int max){
                    if(currentNode == null){
                        return true;
                    }

                    else if(currentNode.val <= min || currentNode.val >= max ){
                        return false;
                    }

                    else{
                        return validityChecker(currentNode.left, min, currentNode.val) && validityChecker(currentNode.right, currentNode.val, max);
                    }
            
                }

        

        public static boolean isValidBST(TreeNode root) {

            //validity checker is a method that is a helper for isValidBST as it goes through and recursively calls using a checking of min and max of current nodes to keep track if the 
        // child nodes are less than current node to the left and that the children nodes to the right are greater than the current node and then checs the continuous children till it passes or fails.

        return validityChecker(root, -2147483647, 2147483647);

        }

        public static void main(String args[]){  
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(3);
            root.right = new TreeNode(8);
            root.left.left = new TreeNode(1);
            root.right.left = new TreeNode(5);
            root.right.right = new TreeNode(9);

            TreeNode root2 = new TreeNode(1);
            root2.left = new TreeNode(2);
            root2.right = new TreeNode(8);
            root2.left.left = new TreeNode(3);
            root2.left.right = new TreeNode(4);
            root2.right.left = new TreeNode(5);
            root2.right.right = new TreeNode(6);
    
            boolean judge = isValidBST(root);
            boolean judge2 = isValidBST(root2);


            System.out.println("Here is the outcome of case1 in the isValidBST() we expect true, we get...:  ");
            System.out.println(judge);
            System.out.println("Here is the outcome of case2 in the isValidBST() we expect false, we get...:  ");
            System.out.println(judge2);
            System.out.println();
        
        
          }
    }


