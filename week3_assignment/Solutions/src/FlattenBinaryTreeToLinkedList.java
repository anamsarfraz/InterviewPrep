/*
 * Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.
 */
public class FlattenBinaryTreeToLinkedList {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
}

	public TreeNode flatten(TreeNode a) {
	    
	    if (a==null) {
	        return a;
	    }
	    
        TreeNode left = flatten(a.left);
        TreeNode right = flatten(a.right);
        
        if (left != null) {
            a.right = left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        }
	    
	    a.left = null;
	    return a;
	    
	}
}
