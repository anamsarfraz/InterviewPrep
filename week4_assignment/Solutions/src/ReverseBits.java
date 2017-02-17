/*
 * Reverse bits of an 32 bit unsigned integer

Example 1:

x = 0,

          00000000000000000000000000000000  
=>        00000000000000000000000000000000
return 0

Example 2:

x = 3,

          00000000000000000000000000000011 
=>        11000000000000000000000000000000
return 3221225472

Since java does not have unsigned int, use long
 */
public class ReverseBits {
	public long reverse(long a) {
	    long result = 0;
	    int count = 0;
	    while (count < 32) {
	        result <<= 1;
	        if (a%2 == 1) {
	            result += 1;
	        }
	        a >>= 1;
	        count++;
	    }
	    
	    return result;
	}
}
