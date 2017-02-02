/*
 * Implement pow(x, n) % d.

In other words, given x, n and d,

find (x^n % d)

Note that remainders on division cannot be negative. 
In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.
 */
public class PowerFunction {
	   public long calcPow(long x, long n, long d) {
	        if (n==0) {
	            return 1;
	        }
	        
	        long result = calcPow(x, n/2, d);
	        result = (result*result) %d;
	        if (n%2 == 1) {
	            return (x%d * result)%d;
	        } else {
	            return result;
	        }
	    }
		public int pow(int x, int n, int d) {
		    long result = calcPow(x%d, n, d)%d;
		    return result >= 0 ? (int)result :  d + (int)result; 
		    
		    
		}
}
