/*
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example :

Given numerator = 1, denominator = 2, return "0.5"
Given numerator = 2, denominator = 1, return "2"
Given numerator = 2, denominator = 3, return "0.(6)"
 */
import java.util.HashMap;

public class Fraction {
	public String fractionToDecimal(int numerator, int denominator) {
	    
	    if (numerator == 0) {
	        return "0";
	    }
	    StringBuffer sb = new StringBuffer();
	    StringBuffer decimal = new StringBuffer();
	    HashMap<Long, Integer> hmap = new HashMap<Long, Integer>(); 
        long r = numerator;
        long d = denominator;
        
	    if (r > 0 ^ d > 0) {
	        sb.append('-');
	    }
	    r = Math.abs(r);
        d = Math.abs(d);

        
	    sb.append(String.valueOf(r/d));
	    r = r %d;

        
        if (r > 0) {
	       sb.append('.');

	    }

        hmap.put(r, 0);
	    while (r > 0) {
	        if (r < d) {
	            r *= 10;
	        }    
	             
	        if (r < d) {
	           decimal.append('0');
	         } else {
                 decimal.append(String.valueOf(r/d));
	             r = r %d;	             
	         }   

	        if (hmap.containsKey(r)) {
	            sb.append(decimal.substring(0, hmap.get(r)));
	            sb.append('(');
	            sb.append(decimal.substring(hmap.get(r)));
	            sb.append(')');
	            break;
	        } else {
	            hmap.put(r, decimal.length());
	        }
	        
	    }
	    
	    if (sb.charAt(sb.length()-1) != ')') {
	        sb.append(decimal.toString());
	    }
	    
	    return sb.toString();
	    
	    
	}
}
