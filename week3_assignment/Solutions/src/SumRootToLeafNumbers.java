/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers % 1003.

Example :

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
 */
public class SumRootToLeafNumbers {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
}
	   /* 
    My initial solution
    
    public void sumNumbersHelper(TreeNode root, int number, ArrayList<Integer> result) {
        int carryNum = 0;
        if (number > 100) {
            carryNum = number/100;
            number = number % 100;
        }
        

        number = ((number * 10) + root.val) - (carryNum*3);
        if (number < 0) {
            number = number+1003;
        }
        if (root.left == null && root.right == null) {
            result.add(number%1003);
            return;
        }
        
        if (root.left != null) {
            sumNumbersHelper(root.left, number, result);
        }
        
        if (root.right != null) {
            sumNumbersHelper(root.right, number, result);
        }
    }
    
	public int sumNumbers(TreeNode a) {
	    
	    if (a == null) {
	        return 0;
	    }
	    
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    sumNumbersHelper(a, 0, result);
	    
	    int sum = 0;
	    
	    for (Integer number: result) {
	        sum = (sum + number) %1003;
	    }
	    
	    return sum%1003;
	}
	
	*/
	
	public int sumNumbersHelper(TreeNode root, int number) {
	    number = ((number * 10) + root.val) % 1003;
	    if (root.left == null && root.right == null) {
            return number;
        }
	    
	    int currSum = 0;
	    if (root.left != null) {
            currSum += sumNumbersHelper(root.left, number);
        }
        
        
        if (root.right != null) {
            currSum += sumNumbersHelper(root.right, number);
        }
        return currSum%1003;
	}
	
	public int sumNumbers(TreeNode a) {
	    if (a == null) {
	        return 0;
	    }
	    
	    return sumNumbersHelper(a, 0);
	}
}
