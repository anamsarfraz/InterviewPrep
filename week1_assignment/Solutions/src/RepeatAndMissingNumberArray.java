
/*
 You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4

 */


/* ISSUE: I am running into overflow issue and can't seem to fix it.
 * */
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumberArray {
	public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
	    
	    long n = a.size();
	    BigInteger diffSquaresBig = new BigInteger("0"); 
	    BigInteger diffBig = new BigInteger("0");
	    long diffSquares = 0; 
        long diff = 0;	    
	    for (int i = 0; i < a.size(); i++) {
	        diffBig = diffBig.add(BigInteger.valueOf(a.get(i) - (i+1)));
	        diffSquaresBig = diffSquaresBig.add(BigInteger.valueOf((a.get(i) * a.get(i)) - ((i+1) * (i+1))));    
	    }
	    
	    diff = diffBig.longValue();
	    diffSquares = diffSquaresBig.longValue();
	    
	    
	    int repeatNum = (int)((diffSquares + (diff*diff))/ (2 * diff));
	    int missingNum = (int)(repeatNum - diff);



	    ArrayList<Integer> result = new ArrayList<Integer>();
	    result.add(repeatNum);
	    result.add(missingNum);
	    
	    return result;
	    
	    
	}
}
