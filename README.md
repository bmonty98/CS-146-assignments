Here is the readme for Lab 4, Lab5, Homework 9 so far. Will be updating this README as time goes on.

Lab 4:
we used a recursive method here to be able to invert a binary search tree, meaning... 
we are turning the left children to right children and right children to left children. We do this
by flipping the pointers of the children of a node and recursively continue until we hit a root node.
as well as this use a method that helps print out trees to command line so we can see the inversion of the BST


Lab 5:

We used here a recursive method that uses a helper method for finding if with any given BST, determine if its valid or not. the main is a little scuffed here so I appoligize about this in the future

Homework9: 

here the main was SUPER SCUFFED. I am so sorry I ran out of time and wanted to write a print method that would allow you to call it for any given BST but couldnt get to that point. BUT!!!! if you were to change any of the values for 
nodes P, Q, R, you would see that it works! I did write a good one though for the java. Again would just translate it over but I have ran out of time and this is where I got too.

the problem in homework 9 is that we are trying to find the Least Common Ancestor between 2 nodes in a BST. we do this by having a method call a recursive helper method where we go through and first check if we have a BST that has nodes. if so,
then we go and check to see if the current node we are on is equal to node p or q if so we have found on of our possible LCA, then we go and check to see if we have found nodes for both p and q in our tree and recursively call until we find their closest
LCA. if we find at least p or Q we know we defintely have a LCA. then we determine if the current node is also p or q which can be our LCA. then if we go through the entire tree and dont find it, then we return null because nothing was found.
