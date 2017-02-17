
/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.
 */
import java.util.ArrayList;

public class GenerateAllParenthesisv2 {
    public void generateParenthesisHelper(ArrayList<String> result, String str, int remainingLeft, int remainingRight) {
        if (remainingLeft > remainingRight) {
            return;
        }
        if (remainingLeft == 0 && remainingRight==0) {
            result.add(str);
            return;
        }
        
        if (remainingLeft > 0) {
            generateParenthesisHelper(result, str+"(", remainingLeft-1, remainingRight);
        }
        
        if (remainingRight > 0) {
            generateParenthesisHelper(result, str+")", remainingLeft, remainingRight-1);
        }
        //System.out.println("res length: "+result.size());
    }
	public ArrayList<String> generateParenthesis(int a) {
	    ArrayList<String> result = new ArrayList<String>();
	    if (a <= 0) {
	        return result;
	    }
	    
	    generateParenthesisHelper(result, "", a, a);
	    return result;
	    
	    
	}
}
