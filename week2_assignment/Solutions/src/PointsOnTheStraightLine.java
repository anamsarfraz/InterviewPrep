/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Sample Input :

(1, 1)
(2, 2)
Sample Output :

2
You will be give 2 arrays X and Y. Each point is represented by (X[i], Y[i])
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;



public class PointsOnTheStraightLine {
	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
	    HashMap<Double, HashMap<Double, HashSet<Integer>>> hmap = new HashMap<Double, HashMap<Double, HashSet<Integer>>>();
	    double slope;
	    double c;
	    
	    if (a.size() <= 1) {
	        return a.size();
	    }
	    
	   int maxLen = 1;
	    for (int i=0; i < a.size()-1; i++) {
	        int currMax = 0;
    	    for (int j=i+1; j < a.size(); j++) {
    	        if (a.get(i) == a.get(j)) {
    	            slope = Double.MAX_VALUE;
    	            c = (double)a.get(i);
    	        } else {
    	            slope = (double)(b.get(i) - b.get(j))/(double)(a.get(i) - a.get(j));
    	            c = (double)b.get(i) - (a.get(i)*slope);
    	        }
    	        
    	        if (!hmap.containsKey(slope)) {
    	            hmap.put(slope, new HashMap<Double, HashSet<Integer>>());
    	            hmap.get(slope).put(c, new HashSet<Integer>());
    	        } else if (!hmap.get(slope).containsKey(c)) {
    	            hmap.get(slope).put(c, new HashSet<Integer>());
    	        }
    	        hmap.get(slope).get(c).add(i);
    	        hmap.get(slope).get(c).add(j);
    	        
    	        currMax = Math.max(currMax, hmap.get(slope).get(c).size());
    	        
    	    }
    	    
    	    maxLen = Math.max(currMax, maxLen);
    	    
    	   
	    }
	    
	
        /*for (Map.Entry<Double, HashMap<Double, HashSet<Integer>>> slopeEntry: hmap.entrySet()) {
            for (Map.Entry<Double, HashSet<Integer>> cEntry: slopeEntry.getValue().entrySet()) {
                if (cEntry.getValue().size() > maxLen) {
                    maxLen = cEntry.getValue().size();
                }
            }
            
        }*/
     
	    
	    return maxLen;

	}

}
