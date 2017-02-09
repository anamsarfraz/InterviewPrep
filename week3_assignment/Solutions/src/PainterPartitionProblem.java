/*
 * You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the constraints that any painter will only paint contiguous sections of board.

2 painters cannot share a board to paint. That is to say, a board
cannot be painted partially by one painter, and partially by another.
A painter will only paint contiguous boards. Which means a
configuration where painter 1 paints board 1 and 3 but not 2 is
invalid.
Return the ans % 10000003

Input :
K : Number of painters
T : Time taken by painter to paint 1 unit of board
L : A List which will represent length of each board

Output:
     return minimum time to paint all boards % 10000003
Example

Input : 
  K : 2
  T : 5
  L : [1, 10]
Output : 50
 */
import java.util.ArrayList;

public class PainterPartitionProblem {
    public int mulmod(int a, int b, int m) {
        int r = 0;
        /* Remove these mods if the caller can ensure a and b are in range */
        a %= m;
        b %= m;
        while (b > 0) {
            if ((b & 1) > 0)  r = ((m-r) > a) ? r+a : r+a-m;    /* r = (r + a) % m */
            b >>= 1;
            if (b > 0)      a = ((m-a) > a) ? a+a : a+a-m;    /* a = (a + a) % m */
        }
        return r;
    }

    
        public boolean isPossible(int a, int b, ArrayList<Integer> c, int currMax) {
        int currSum = 0;
        int numPainters = 1;
        
        for (int i=0; i < c.size(); i++) {
            if (c.get(i) > currMax) {
                return false;
            } 
            
            
            if ((c.get(i))+currSum > currMax) {
                numPainters++;
                currSum = c.get(i);
                if (numPainters > a) {
                    return false;
                }
                
            } else {
                currSum += c.get(i);
            }
            
            
        }
        
        return true;    

    }
    
	public int paint(int a, int b, ArrayList<Integer> c) {
	   
	    
	    //int minMax = Integer.MAX_VALUE;
	    int sum = 0;
        int maxJob = 0;
        
	    for (int i=0; i < c.size(); i++) {
	        sum += c.get(i);
	        if (c.get(i) > maxJob) {
	            maxJob = (c.get(i));
	        }
	    }

	    int start = 0;
	    int end = sum;
	    int mid;
	    
	    while (start <= end) {
	        mid = (start+end)/2;
	        if (isPossible(a, b, c, mid)) {
	            maxJob = mid;
	            end = mid-1;
	        } else {
	            start = mid+1;
	        }
	    }
	    
	    
	    return mulmod(maxJob, b, 10000003);
	}
}
