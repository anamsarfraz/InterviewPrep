/*
 * Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Example :

Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Output : 4
 */
import java.util.List;
public class SingleNumberv2 {
	// DO NOT MODIFY THE LIST
	public int singleNumber(final List<Integer> a) {
	    
	    int[] count = new int[32];
	    int result = 0;
	    for (int i=0; i < count.length; i++) {
	        for (int j=0; j < a.size(); j++) {
	            if (((a.get(j) >> i) & 1) > 0) {
	                count[i]++;
	            }
	        }
	        result |= (count[i]%3) <<i;
	        
	    }
	    
	    return result;
	    
	}

}
