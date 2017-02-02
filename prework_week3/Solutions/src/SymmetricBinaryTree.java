/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example :

    1
   / \
  2   2
 / \ / \
3  4 4  3
The above binary tree is symmetric. 
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class SymmetricBinaryTree {
	class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
}
    public int checkSymmetry(TreeNode left, TreeNode right) {
        
        if (left == null && right == null) {
            return 1;
        }
        if (left == null || right == null) {
            return 0;
        }
        
        if (left.val != right.val) {
            return 0;
        }
        
        return Math.min(checkSymmetry(left.right, right.left), checkSymmetry(left.left, right.right));
    }
    
	public int isSymmetric(TreeNode a) {
	    if (a == null) {
	        return 0;
	    }
	    
        return checkSymmetry(a.left, a.right);
	    
	    
	}
}
