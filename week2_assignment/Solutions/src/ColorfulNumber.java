/*
 * For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1
 */

import java.util.HashSet;
import java.util.ArrayList;

public class ColorfulNumber {
	public int colorful(int a) {
	    if (a < 10) {
	        return 1;
	    }
	    
	    int product = 1;
	    int num = a;
	    
	    HashSet<Integer> hs = new HashSet<Integer>();
	    ArrayList<Integer> arr = new ArrayList<Integer>();
	    
	    while (num > 0) {
	        int digit = num%10;
	        
	        product *= digit;
	        if (digit == 1 || digit == 0 || hs.contains(digit) || hs.contains(product)) {
	            return 0;
	        }
	        
	        
	        num /= 10;
	        
	        hs.add(digit);
	        hs.add(product);
	        arr.add(digit);
	        
	    }
	    
	    
	
	    for (int i=1; i < arr.size()-1; i++) {
	        product = arr.get(i);
	        
	        for (int j=i+1; j < arr.size(); j++) {
	            product *= arr.get(j);
	            
	            if (hs.contains(product)) {

	                return 0;
	            }
	            
	            hs.add(product);
	        }
	    }
	    
	    return 1;
	    
	}


}
