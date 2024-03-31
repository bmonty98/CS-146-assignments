import java.util.*;

public class HW10 {

    
        

        /*
 * per the hints this is what were gonna do:
 * Step1: create a Queue and a list, then what we do is check if root is check if Null, then return null if thats the case.
 * Step2: do a while loop that constantly checks i the queue is empty and creates a sublist
 * Step3: do a for loop for as long as the current length of the queue size before every loop updates it, which would represent the nodes in one level of tree
 * Step4: then at the end concatenate that inner list into the main list whch represents are BST transversal and then return it
 * READY GO!
 */
        public List<List<Integer>> levelOrder(TreeNode root) {
            ArrayList<TreeNode> thy_queue = new ArrayList<TreeNode>(); // using this arrylist like a queue...
            List<List<Integer>> BFS_representation = new ArrayList<List<Integer>>();

            if(root == null){
                return null;
            }

            thy_queue.add(root);

            while(!thy_queue.isEmpty()){
                List<Integer> subList = new ArrayList<Integer>();
                int currentLevelSize = thy_queue.size();
                for(int i = 0; i < currentLevelSize; i++){
                    TreeNode currentNode = new TreeNode();
                    //simulating the pop of a queue with a linked list----

                    currentNode = thy_queue.get(0); // get value
                    thy_queue.remove(0); // pop()

                    if (currentNode != null){
                        subList.add(currentNode.val);
                        if(currentNode.left != null){
                            thy_queue.add(currentNode.left);
                        }
                        if(currentNode.right != null){
                            thy_queue.add(currentNode.right);
                        }
                    }
                }
                if(subList.size() > 0){
                    BFS_representation.add(subList);
                }

            }
            return BFS_representation;
    }


     public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        TreeNode root2 = new TreeNode(17);
        root2.left = new TreeNode(7);
        TreeNode root3 = new TreeNode(69);
        
        // testing variables to store the lists. 
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        List<List<Integer>> solution2 = new ArrayList<List<Integer>>();
        List<List<Integer>> solution3 = new ArrayList<List<Integer>>();
        List<List<Integer>> solution4 = new ArrayList<List<Integer>>();

        HW10 bot = new HW10(); // again java be pretty dum sometimes :(    ima come to office hours and get reminded of a way to avoid this.

        solution = bot.levelOrder(root);
        //BFSPrinter(solution)
        solution2 = bot.levelOrder(null);
        //BFSPrinter(solution2)
        solution3 = bot.levelOrder(root2);
        //BFSPrinter(solution)
        solution4 = bot.levelOrder(root3);
        //BFSPrinter(solution)

        System.out.println(solution);
        System.out.println(solution2);
        System.out.println(solution3);
        System.out.println(solution4);





        
     }
    
}



