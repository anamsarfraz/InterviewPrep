/*
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.

Example:

The 32-bit integer 11 has binary representation

00000000000000000000000000001011
so the function should return 3.

Note that since Java does not have unsigned int, use long for Java
 */
public class NumberOfOneBits {
	public int numSetBits(long a) {
	    int numOneBits = 0;
	    while (a > 0) {
	        if ((a&1) != 0) {
	            numOneBits ++;
	        }
	        a >>= 1;
	    }
	    
	    return numOneBits;
	}
}
