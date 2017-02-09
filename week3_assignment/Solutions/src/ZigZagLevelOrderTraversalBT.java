/*
 * Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).

Example : 
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return

[
         [3],
         [20, 9],
         [15, 7]
]
 */
 import java.util.Queue;
 import java.util.LinkedList;
 import java.util.ArrayList;
 
public class ZigZagLevelOrderTraversalBT {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
}
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    
	    int level = 0;
	    
	    if (a != null) {
	        queue.add(a);
	        queue.add(null);
	    }
	    
	    result.add(new ArrayList<Integer>());
	    
	    while (!queue.isEmpty()) {
	        
	        
	        TreeNode node = queue.remove();
	        
	        if (node != null) {
	           if (level%2==1) {
	               result.get(level).add(0, node.val);
	           } else {
	               result.get(level).add(node.val);
	           }
	           
	           
	           //if ((level+1)%2 == 0) {
    	           if (node.left != null) {
    	               queue.add(node.left);
    	           }
    	           
    	           if (node.right != null) {
    	               queue.add(node.right);
    	           }
	           /*} else {
    	           if (node.right != null) {
    	               queue.add(node.right);
    	           }
    	           
    	           if (node.left != null) {
    	               queue.add(node.left);
    	           }
	           }*/

	        } else if (!queue.isEmpty()){
	            result.add(new ArrayList<Integer>());
	            queue.add(null);
	            level++;
	        }
	        
	    }
	    return result;
	    
	}
}
