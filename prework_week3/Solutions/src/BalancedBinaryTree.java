/*
 * Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 
          1
         / \
        2   3

Return : True or 1 

Input 2 : 
         3
        /
       2
      /
     1

Return : False or 0 
         Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
         Difference = 2 > 1. 
 */
public class BalancedBinaryTree {
	class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
    }
	
    public int[] isBalanceWithDepth(TreeNode a) {
        int[] arr = {0, 1};
        if (a== null) {
            return arr;
        }
        
        int[] arrLeft = isBalanceWithDepth(a.left);
        int[] arrRight = isBalanceWithDepth(a.right);
        
        arr[0] = 1+Math.max(arrLeft[0], arrRight[0]);
        arr[1] = arrLeft[1] == 1 && arrRight[1] == 1 && Math.abs(arrLeft[0] - arrRight[0]) < 2 ? 1 : 0;
        
        
        
        return arr;
        
        
    }
	public int isBalanced(TreeNode a) {
	    
        return isBalanceWithDepth(a)[1];
	    
	    
	    
	}
}
